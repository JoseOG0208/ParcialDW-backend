package com.ejemplo.organizacionbackend.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.organizacionbackend.dto.ContratoDTO;
import com.ejemplo.organizacionbackend.entity.Contrato;
import com.ejemplo.organizacionbackend.repository.ContratoRepository;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    // convertir contrato a DTO con conversión adecuada de fechas
    private ContratoDTO convertirContratoDTO(Contrato contrato) {
        return new ContratoDTO(
                contrato.getId(),
                contrato.getIdentificador(),
                contrato.getValor(),
                contrato.getNombre_contratante(),
                contrato.getDocumento_contratante(),
                contrato.getNombre_contratista(),
                contrato.getDocumento_contratista(),
                contrato.getFecha_inicio() != null ? new Date(contrato.getFecha_inicio().getTime()) : null,
                contrato.getFecha_fin() != null ? new Date(contrato.getFecha_fin().getTime()) : null
        );
    }

    // obtener todos los contratos
    public List<ContratoDTO> obtenerTodos() {
        List<Contrato> contratos = contratoRepository.findAll();
        System.out.println("Contratos obtenidos: " + contratos.size());
        return contratos.stream()
                       .map(this::convertirContratoDTO)
                       .collect(Collectors.toList());
    }

    // obtener contrato por ID
    public ContratoDTO obtenerPorId(Long id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);
        return contrato.map(this::convertirContratoDTO).orElse(null);
    }

    // crear nuevo contrato
    public ContratoDTO crearContrato(Contrato contrato) {
        Contrato nuevoContrato = contratoRepository.save(contrato);
        return convertirContratoDTO(nuevoContrato);
    }

    // actualizar contrato existente
    public ContratoDTO actualizarContrato(Long id, Contrato contratoActualizado) {
        Optional<Contrato> contratoExistente = contratoRepository.findById(id);

        if (contratoExistente.isPresent()) {
            Contrato contrato = contratoExistente.get();
            contrato.setIdentificador(contratoActualizado.getIdentificador());
            contrato.setValor(contratoActualizado.getValor());
            contrato.setNombre_contratante(contratoActualizado.getNombre_contratante());
            contrato.setDocumento_contratante(contratoActualizado.getDocumento_contratante());
            contrato.setNombre_contratista(contratoActualizado.getNombre_contratista());
            contrato.setDocumento_contratista(contratoActualizado.getDocumento_contratista());
            contrato.setFecha_inicio(contratoActualizado.getFecha_inicio());
            contrato.setFecha_fin(contratoActualizado.getFecha_fin());

            contratoRepository.save(contrato);
            return convertirContratoDTO(contrato);
        }
        return null;
    }

    // eliminar contrato por ID
    public boolean eliminarContrato(Long id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);
        if (contrato.isPresent()) {
            contratoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

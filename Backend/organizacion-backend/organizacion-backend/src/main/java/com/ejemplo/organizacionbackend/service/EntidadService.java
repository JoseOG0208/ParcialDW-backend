package com.ejemplo.organizacionbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.organizacionbackend.dto.EntidadDTO;
import com.ejemplo.organizacionbackend.entity.Entidad;
import com.ejemplo.organizacionbackend.repository.EntidadRepository;

@Service
public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    // convertir entidad a DTO
    private EntidadDTO convertirEntidadDTO(Entidad entidad) {
        return new EntidadDTO(
                entidad.getId(),
                entidad.getNit(),
                entidad.getNombre(),
                entidad.getContratos()
        );
    }

    // obtener todas las entidades
    public List<EntidadDTO> obtenerTodos() {
        List<Entidad> entidades = entidadRepository.findAll();
        System.out.println("Entidades obtenidas: " + entidades.size());
        return entidades.stream()
                        .map(this::convertirEntidadDTO)
                        .collect(Collectors.toList());
    }

    // obtener por ID
    public EntidadDTO obtenerPorId(Long id) {
        Optional<Entidad> entidad = entidadRepository.findById(id);
        return entidad.map(this::convertirEntidadDTO).orElse(null);
    }

    // crear entidad
    public EntidadDTO crearEntidad(Entidad entidad) {
        Entidad nuevaEntidad = entidadRepository.save(entidad);
        return convertirEntidadDTO(nuevaEntidad);
    }

    // actualizar entidad
    public EntidadDTO actualizarEntidad(Long id, Entidad entidadActualizada) {
        Optional<Entidad> entidadExistente = entidadRepository.findById(id);

        if (entidadExistente.isPresent()) {
            Entidad entidad = entidadExistente.get();
            entidad.setNit(entidadActualizada.getNit());
            entidad.setNombre(entidadActualizada.getNombre());
            entidad.setContratos(entidadActualizada.getContratos());

            entidadRepository.save(entidad);
            return convertirEntidadDTO(entidad);
        }
        return null;
    }

    // eliminar entidad
    public boolean eliminarEntidad(Long id) {
        Optional<Entidad> entidad = entidadRepository.findById(id);
        if (entidad.isPresent()) {
            entidadRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

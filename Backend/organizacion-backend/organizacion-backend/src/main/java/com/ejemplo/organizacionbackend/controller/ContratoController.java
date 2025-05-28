package com.ejemplo.organizacionbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.organizacionbackend.dto.ContratoDTO;
import com.ejemplo.organizacionbackend.entity.Contrato;
import com.ejemplo.organizacionbackend.service.ContratoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> obtenerTodos() {
        return ResponseEntity.ok(contratoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtenerPorId(@PathVariable Long id) {
        ContratoDTO contrato = contratoService.obtenerPorId(id);
        return contrato != null ? ResponseEntity.ok(contrato) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> crearContrato(@RequestBody Contrato contrato) {
        return ResponseEntity.ok(contratoService.crearContrato(contrato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        ContratoDTO contratoActualizado = contratoService.actualizarContrato(id, contrato);
        return contratoActualizado != null ? ResponseEntity.ok(contratoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Long id) {
        return contratoService.eliminarContrato(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

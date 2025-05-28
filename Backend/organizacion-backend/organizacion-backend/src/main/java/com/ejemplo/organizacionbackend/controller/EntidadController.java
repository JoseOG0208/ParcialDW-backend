package com.ejemplo.organizacionbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.organizacionbackend.dto.EntidadDTO;
import com.ejemplo.organizacionbackend.entity.Entidad;
import com.ejemplo.organizacionbackend.service.EntidadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/entidades")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @GetMapping
    public ResponseEntity<List<EntidadDTO>> obtenerTodos() {
        return ResponseEntity.ok(entidadService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDTO> obtenerPorId(@PathVariable Long id) {
        EntidadDTO entidad = entidadService.obtenerPorId(id);
        return entidad != null ? ResponseEntity.ok(entidad) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EntidadDTO> crearEntidad(@RequestBody Entidad entidad) {
        return ResponseEntity.ok(entidadService.crearEntidad(entidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadDTO> actualizarEntidad(@PathVariable Long id, @RequestBody Entidad entidad) {
        EntidadDTO entidadActualizada = entidadService.actualizarEntidad(id, entidad);
        return entidadActualizada != null ? ResponseEntity.ok(entidadActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEntidad(@PathVariable Long id) {
        return entidadService.eliminarEntidad(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

package com.ejemplo.organizacionbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.organizacionbackend.entity.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {

}

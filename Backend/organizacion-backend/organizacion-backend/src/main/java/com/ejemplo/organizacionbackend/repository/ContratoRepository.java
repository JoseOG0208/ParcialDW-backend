package com.ejemplo.organizacionbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejemplo.organizacionbackend.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}

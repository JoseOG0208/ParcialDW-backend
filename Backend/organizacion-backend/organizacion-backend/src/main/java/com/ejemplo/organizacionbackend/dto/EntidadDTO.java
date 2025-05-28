package com.ejemplo.organizacionbackend.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ejemplo.organizacionbackend.entity.Contrato;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntidadDTO {

    private Long id;
    private String nit;
    private String nombre;
    private List<Contrato> contratos;
}

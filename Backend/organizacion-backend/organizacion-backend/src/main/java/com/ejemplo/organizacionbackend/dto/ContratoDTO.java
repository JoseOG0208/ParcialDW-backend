package com.ejemplo.organizacionbackend.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO {
    private Long id;
    private String identificador;
    private double valor;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratista;
    private String documento_contratista;
    private Date fecha_inicio;
    private Date fecha_fin;
}

package com.ejemplo.organizacionbackend.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private double valor;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratista;
    private String documento_contratista;
    private Date fecha_inicio;
    private Date fecha_fin;

    @ManyToOne
    @JoinColumn(name = "entidad_id")
    private Entidad entidad; 
}

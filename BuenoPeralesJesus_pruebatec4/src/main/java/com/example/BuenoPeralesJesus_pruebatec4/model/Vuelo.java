package com.example.BuenoPeralesJesus_pruebatec4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String numeroVuelo;
    private String nombre;
    private String origen;
    private String destino;
    private String tipoAsiento;
    private Double precioVuelo;
    private LocalDate fechaIda;
    private LocalDate fechaVuelta;
}

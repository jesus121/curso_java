package com.example.BuenoPeralesJesus_pruebatec4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReservaVuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fecha;
    private String origen;
    private String destino;
    private String codigoVuelo;
    private Integer numeroPersona;
    private String tipoAsiento;
    private String nombrePersona;

    @OneToMany
    private List<Vuelo> vuelo;
}

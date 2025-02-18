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
public class ReservaHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fechaLlegada;
    private LocalDate fechaIda;
    private Integer noche;
    private String lugar;
    private String codigoHotel;
    private Integer persona;
    private String tipoHabitacion;
    private String nombrePersona;

    @OneToOne
    private Hotel hotel;
}

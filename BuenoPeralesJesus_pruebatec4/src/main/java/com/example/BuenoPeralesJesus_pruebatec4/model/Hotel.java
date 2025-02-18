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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String codigoHotel;
    private String nombre;
    private String lugar;
    private String habitacion;
    private Double precioHabitacion;
    private LocalDate fechaInicioDisponible;
    private LocalDate fechaFinalDisponible;
    private Boolean reserva;
}

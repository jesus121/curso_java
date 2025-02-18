package com.example.BuenoPeralesJesus_pruebatec4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private String codigoHotel;
    private String nombre;
    private String lugar;
    private String habitacion;
    private Double precioHabitacion;
    private LocalDate fechaInicioDisponible;
    private LocalDate fechaFinalDisponible;
    private Boolean reserva;
}

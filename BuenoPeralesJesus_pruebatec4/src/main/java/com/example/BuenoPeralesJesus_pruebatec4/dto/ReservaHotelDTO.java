package com.example.BuenoPeralesJesus_pruebatec4.dto;

import com.example.BuenoPeralesJesus_pruebatec4.model.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaHotelDTO {

    private LocalDate fechaLlegada;
    private LocalDate fechaIda;
    private Integer noche;
    private String lugar;
    private String codigoHotel;
    private Integer persona;
    private String tipoHabitacion;
    private String nombrePersona;
    private Hotel hotel;
}

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
public class VueloDTO {

    private String numeroVuelo;
    private String nombre;
    private String origen;
    private String destino;
    private String tipoAsiento;
    private Double precioVuelo;
    private LocalDate fechaIda;
    private LocalDate fechaVuelta;

}

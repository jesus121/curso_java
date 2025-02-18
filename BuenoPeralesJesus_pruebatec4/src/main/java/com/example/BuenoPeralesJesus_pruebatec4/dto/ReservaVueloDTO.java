package com.example.BuenoPeralesJesus_pruebatec4.dto;

import com.example.BuenoPeralesJesus_pruebatec4.model.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaVueloDTO {

    private LocalDate fecha;
    private String origen;
    private String Destino;
    private String codigoVuelo;
    private Integer numeroPersona;
    private String tipoAsiento;
    private String nombrePersona;
    private Vuelo vuelo;
}

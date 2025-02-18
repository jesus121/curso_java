package com.example.BuenoPeralesJesus_pruebatec4.service;

import com.example.BuenoPeralesJesus_pruebatec4.dto.VueloDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Vuelo;

import java.time.LocalDate;
import java.util.List;

public interface IVueloService {

    //Metodo 4 y 5 de vuelos
    public List<VueloDTO> todoVuelo ();
    public List<VueloDTO> todoVueloFechaDestino (LocalDate fechaIda,LocalDate fechaVuelta,String destino,String origen);
    //Metodo 7 de vuelos
    public String guardarVuelo (VueloDTO vueloDTO);
    public String editarVuelo (Long id , VueloDTO vueloDTO);
    public String eliminarVuelo (Long id);
    public Vuelo vueloId (Long id);
}

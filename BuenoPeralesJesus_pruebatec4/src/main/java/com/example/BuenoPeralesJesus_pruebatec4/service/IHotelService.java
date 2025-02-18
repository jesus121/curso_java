package com.example.BuenoPeralesJesus_pruebatec4.service;

import com.example.BuenoPeralesJesus_pruebatec4.dto.HotelDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {

    //Metodo 1 y 2 hotel
    public List<HotelDTO> todoHotel ();
    public List<HotelDTO> todoHotelFechaDestino(LocalDate fechaInicioDisponible, LocalDate fechaFinalDisponible, String lugar);
    // Metodo 7 Hotel
    public String guardarHotel (HotelDTO hotelDTO);
    public String editalHotel (Long id ,HotelDTO hotelDTO);
    public String eliminarHotel (Long id);
    public Hotel hotelId (Long id);
}

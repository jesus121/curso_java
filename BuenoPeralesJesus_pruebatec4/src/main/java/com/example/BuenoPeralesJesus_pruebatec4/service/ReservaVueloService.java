package com.example.BuenoPeralesJesus_pruebatec4.service;

import com.example.BuenoPeralesJesus_pruebatec4.dto.ReservaVueloDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.ReservaVuelo;
import com.example.BuenoPeralesJesus_pruebatec4.model.Vuelo;
import com.example.BuenoPeralesJesus_pruebatec4.repository.ReservaVueloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservaVueloService implements IReservaVueloService{

    private final ReservaVueloRepository reservaVueloRepository;
    private final IVueloService vueloService;

    public ReservaVueloService(ReservaVueloRepository reservaVueloRepository, IVueloService vueloService) {
        this.reservaVueloRepository = reservaVueloRepository;
        this.vueloService = vueloService;
    }

    @Override
    public String guardar (ReservaVueloDTO reservaVueloDTO){
        Vuelo vuelo = vueloService.vueloId(reservaVueloDTO.getVuelo().getId());
        if (vuelo == null) {
            return "El vuelo no existe.";
        }
        reservaVueloRepository.save(mapEntityToDto(reservaVueloDTO));
        Double resultado = reservaVueloDTO.getNumeroPersona() * reservaVueloDTO.getVuelo().getPrecioVuelo();
        return resultado.toString();
    }



    public ReservaVuelo mapEntityToDto (ReservaVueloDTO reservaVueloDTO){
        ReservaVuelo reservaVuelo = new ReservaVuelo();
        reservaVuelo.setFecha(reservaVueloDTO.getFecha());
        reservaVuelo.setOrigen(reservaVueloDTO.getOrigen());
        reservaVuelo.setDestino(reservaVueloDTO.getDestino());
        reservaVuelo.setCodigoVuelo(reservaVueloDTO.getCodigoVuelo());
        reservaVuelo.setNumeroPersona(reservaVueloDTO.getNumeroPersona());
        reservaVuelo.setTipoAsiento(reservaVueloDTO.getTipoAsiento());
        reservaVuelo.setNombrePersona(reservaVueloDTO.getNombrePersona());

        Vuelo vuelo = new Vuelo();
        vuelo.setId(reservaVueloDTO.getVuelo().getId());


        return reservaVuelo;
    }

    public ReservaVueloDTO mapDtoToEntity (ReservaVuelo reservaVuelo){
        ReservaVueloDTO reservaVueloDTO = new ReservaVueloDTO();
        reservaVueloDTO.setFecha(reservaVuelo.getFecha());
        reservaVueloDTO.setOrigen(reservaVuelo.getOrigen());
        reservaVueloDTO.setDestino(reservaVuelo.getDestino());
        reservaVueloDTO.setCodigoVuelo(reservaVuelo.getCodigoVuelo());
        reservaVueloDTO.setNumeroPersona(reservaVuelo.getNumeroPersona());
        reservaVueloDTO.setTipoAsiento(reservaVuelo.getTipoAsiento());
        reservaVueloDTO.setNombrePersona(reservaVuelo.getNombrePersona());
        return reservaVueloDTO;
    }
}

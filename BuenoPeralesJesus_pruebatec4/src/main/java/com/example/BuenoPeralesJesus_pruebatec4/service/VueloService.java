package com.example.BuenoPeralesJesus_pruebatec4.service;

import com.example.BuenoPeralesJesus_pruebatec4.dto.VueloDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Vuelo;
import com.example.BuenoPeralesJesus_pruebatec4.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
public class VueloService implements IVueloService {


    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<VueloDTO> todoVuelo() {
        return vueloRepository.findAll().stream().map(this::mapDtoToEntity).toList();
    }



    @Override
    public List<VueloDTO> todoVueloFechaDestino(LocalDate fechaIda, LocalDate fechaVuelta, String destino, String origen) {
        return vueloRepository.findAll().stream().map(this::mapDtoToEntity)
                .filter(p->p.getFechaIda().equals(fechaIda)
                        && p.getFechaVuelta().equals(fechaVuelta))
                .filter(p->p.getDestino().equals(destino)
                        && p.getOrigen().equals(origen))
                .toList();
    }

    @Override
    public String guardarVuelo(VueloDTO vueloDTO) {
        vueloRepository.save(mapEntityToDto(vueloDTO));

        return "Se ha guardado con exito";
    }

    @Override
    public String editarVuelo(Long id , VueloDTO vueloDTO) {
        Vuelo filtradovuelo = vueloRepository.findById(id).orElse(null);
        if (filtradovuelo.getId() == null){
            return "El campo ID no puede ser nulo. No se pudo actualizar.";
        }

        Vuelo vuelo = mapEntityToDto(vueloDTO);
        if (Objects.nonNull(vuelo)) {
            vuelo.setId(id);
            vueloRepository.save(vuelo);
            return "Se actualizó con éxito.";
        } else {
            return "No se encontró el elemento con ID " + id + ". No se pudo actualizar.";
        }

    }




    @Override
    public String eliminarVuelo(Long id) {
        Vuelo filtroVuelo =vueloRepository.findById(id).orElse(null);
        if (Objects.nonNull(filtroVuelo)){
            vueloRepository.deleteById(id);
            return "Se eliminó con éxito.";
        }else {
            return "No se encontró el elemento con ID " + id + ". No se pudo eliminar.";
        }
    }


    @Override
    public Vuelo vueloId(Long id) {
        return vueloRepository.findById(id).orElse(null);
    }

    public Vuelo  mapEntityToDto(VueloDTO vueloDTO){
        Vuelo vuelo = new Vuelo();
        vuelo.setNumeroVuelo(vueloDTO.getNumeroVuelo());
        vuelo.setNombre(vueloDTO.getNombre());
        vuelo.setOrigen(vueloDTO.getOrigen());
        vuelo.setDestino(vueloDTO.getDestino());
        vuelo.setTipoAsiento(vueloDTO.getTipoAsiento());
        vuelo.setPrecioVuelo(vueloDTO.getPrecioVuelo());
        vuelo.setFechaIda(vueloDTO.getFechaIda());
        vuelo.setFechaVuelta(vueloDTO.getFechaVuelta());

        return vuelo;
    }

    public VueloDTO  mapDtoToEntity  (Vuelo vuelo){
        VueloDTO vueloDTO = new VueloDTO();
        vueloDTO.setNumeroVuelo(vuelo.getNumeroVuelo());
        vueloDTO.setNombre(vuelo.getNombre());
        vueloDTO.setOrigen(vuelo.getOrigen());
        vueloDTO.setDestino(vuelo.getDestino());
        vueloDTO.setTipoAsiento(vuelo.getTipoAsiento());
        vueloDTO.setPrecioVuelo(vuelo.getPrecioVuelo());
        vueloDTO.setFechaIda(vuelo.getFechaIda());
        vueloDTO.setFechaVuelta(vuelo.getFechaVuelta());

        return vueloDTO;
    }
}

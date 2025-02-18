package com.example.BuenoPeralesJesus_pruebatec4.service;

import com.example.BuenoPeralesJesus_pruebatec4.dto.HotelDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Hotel;
import com.example.BuenoPeralesJesus_pruebatec4.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
public class HotelService implements IHotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelDTO> todoHotel() {
        return hotelRepository.findAll().stream().map(this::mapEntityToDto).toList();
    }

    @Override
    public List<HotelDTO> todoHotelFechaDestino(LocalDate fechaInicioDisponible, LocalDate fechaFinalDisponible,String lugar) {
        return hotelRepository.findAll().stream()
                .filter(p-> p.getFechaInicioDisponible().equals(fechaInicioDisponible)
                        && p.getFechaFinalDisponible().equals(fechaFinalDisponible))
                .filter(p->p.getLugar().equals(lugar)).map(this::mapEntityToDto)
                .toList();
    }

    @Override
    public String guardarHotel(HotelDTO hotelDTO) {
        // Al crear un vuelo este campo es siempre falso porque no se crea con una reserva
        hotelDTO.setReserva(false);
        hotelRepository.save(mapDtoToEntity(hotelDTO));
        return "Se ha guardado con exito";
    }

    @Override
    public String editalHotel(Long id , HotelDTO hotelDTO) {
        Hotel filtradoHotel = hotelRepository.findById(id).orElse(null);
        if (filtradoHotel.getId() == null){
            return "El campo ID no puede ser nulo. No se pudo actualizar.";
        }
        Hotel hotel = mapDtoToEntity(hotelDTO);
        if (Objects.nonNull(hotel)) {
            hotel.setId(id);
            hotelRepository.save(hotel);
            return "Se actualizó con éxito.";
        } else {
            return "No se encontró el elemento con ID " + filtradoHotel.getId() + ". No se pudo actualizar.";
        }
    }

    @Override
    public String eliminarHotel(Long id) {
        Hotel filtroHotel = hotelRepository.findById(id).orElse(null);
        if (filtroHotel.getReserva() == true ){
            return "El hotel esta reservado . No se puedo eliminar";
        }
        if (Objects.nonNull(filtroHotel)){
            if(filtroHotel.getReserva()){
                return "No se puede eliminar, tiene una reserva registrada.";
            }
            hotelRepository.deleteById(id);
            return "Se eliminó con éxito.";
        }else {
            return "No se encontró el elemento con ID " + id + ". No se pudo eliminar.";
        }

    }

    @Override
    public Hotel hotelId(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }



    public Hotel mapDtoToEntity  (HotelDTO hotelDTO){
        Hotel hotel = new Hotel();

        hotel.setCodigoHotel(hotelDTO.getCodigoHotel());
        hotel.setLugar(hotelDTO.getLugar());
        hotel.setNombre(hotelDTO.getNombre());
        hotel.setHabitacion(hotelDTO.getHabitacion());
        hotel.setFechaInicioDisponible(hotelDTO.getFechaInicioDisponible());
        hotel.setFechaFinalDisponible(hotelDTO.getFechaFinalDisponible());
        hotel.setReserva(hotelDTO.getReserva());
        hotel.setPrecioHabitacion(hotelDTO.getPrecioHabitacion());
        return hotel;
    }

    public HotelDTO mapEntityToDto  (Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setCodigoHotel(hotel.getCodigoHotel());
        hotelDTO.setNombre(hotel.getNombre());
        hotelDTO.setLugar(hotel.getLugar());
        hotelDTO.setHabitacion(hotel.getHabitacion());
        hotelDTO.setPrecioHabitacion(hotel.getPrecioHabitacion());
        hotelDTO.setFechaInicioDisponible(hotel.getFechaInicioDisponible());
        hotelDTO.setFechaFinalDisponible(hotel.getFechaFinalDisponible());
        hotelDTO.setReserva(hotel.getReserva());
        return hotelDTO;
    }
}

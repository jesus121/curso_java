package com.example.BuenoPeralesJesus_pruebatec4.service;


import com.example.BuenoPeralesJesus_pruebatec4.dto.ReservaHotelDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Hotel;
import com.example.BuenoPeralesJesus_pruebatec4.model.ReservaHotel;
import com.example.BuenoPeralesJesus_pruebatec4.repository.ReservaHotelRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaHotelService implements IReservaHotelService {

    private final ReservaHotelRepository reservaHotelRepository;
    private final HotelService hotelService;

    public ReservaHotelService(ReservaHotelRepository reservaHotelRepository, HotelService hotelService) {
        this.reservaHotelRepository = reservaHotelRepository;
        this.hotelService = hotelService;
    }

    @Override
    public String guardar(ReservaHotelDTO reservaHotelDTO) {
        Hotel hotel = hotelService.hotelId(reservaHotelDTO.getHotel().getId());
        if (hotel == null) {
            return "El hotel no existe.";
        }
        if (reservaHotelDTO.getFechaLlegada().isBefore(hotel.getFechaInicioDisponible()) ||
                reservaHotelDTO.getFechaLlegada().isAfter(hotel.getFechaFinalDisponible())) {
            return "El rango de fecha no se encuntra ningun hotel";
        }
        if (hotel.getReserva()) {
            return "El hotel ya está reservado.";
        }
        reservaHotelRepository.save(mapDtoToEntity(reservaHotelDTO));
        Double resultado = reservaHotelDTO.getNoche() * reservaHotelDTO.getHotel().getPrecioHabitacion();
        hotelService.editalHotel(reservaHotelDTO.getHotel().getId() , hotelService.mapEntityToDto(hotel));
        hotel.setReserva(true);
        hotelService.guardarHotel(hotelService.mapEntityToDto(hotel));
        return resultado.toString();
    }

    public ReservaHotel mapDtoToEntity (ReservaHotelDTO reservaHotelDTO){
        ReservaHotel reservaHotel = new ReservaHotel();
        reservaHotel.setFechaLlegada(reservaHotelDTO.getFechaLlegada());
        reservaHotel.setFechaIda(reservaHotelDTO.getFechaIda());
        reservaHotel.setNoche(reservaHotelDTO.getNoche());
        reservaHotel.setLugar(reservaHotelDTO.getLugar());
        reservaHotel.setCodigoHotel(reservaHotelDTO.getCodigoHotel());
        reservaHotel.setPersona(reservaHotelDTO.getPersona());
        reservaHotel.setTipoHabitacion(reservaHotelDTO.getTipoHabitacion());
        reservaHotel.setNombrePersona(reservaHotelDTO.getNombrePersona());

        Hotel hotel = new Hotel();
        hotel.setId(reservaHotelDTO.getHotel().getId());
        reservaHotel.setHotel(reservaHotelDTO.getHotel());

        return reservaHotel;
    }

    public ReservaHotelDTO mapEntityToDto (ReservaHotel reservaHotel){
        ReservaHotelDTO reservaHotelDTO = new ReservaHotelDTO();
        reservaHotelDTO.setFechaLlegada(reservaHotel.getFechaLlegada());
        reservaHotelDTO.setFechaIda(reservaHotel.getFechaIda());
        reservaHotelDTO.setNoche(reservaHotel.getNoche());
        reservaHotelDTO.setLugar(reservaHotel.getLugar());
        reservaHotelDTO.setCodigoHotel(reservaHotel.getCodigoHotel());
        reservaHotelDTO.setPersona(reservaHotel.getPersona());
        reservaHotelDTO.setTipoHabitacion(reservaHotel.getTipoHabitacion());
        reservaHotelDTO.setNombrePersona(reservaHotel.getNombrePersona());
        return reservaHotelDTO;
    }
}

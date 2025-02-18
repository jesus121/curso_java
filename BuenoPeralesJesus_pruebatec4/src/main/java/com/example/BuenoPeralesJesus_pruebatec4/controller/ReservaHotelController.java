package com.example.BuenoPeralesJesus_pruebatec4.controller;


import com.example.BuenoPeralesJesus_pruebatec4.dto.ReservaHotelDTO;
import com.example.BuenoPeralesJesus_pruebatec4.service.ReservaHotelService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agency/room-booking")
public class ReservaHotelController {

    private final ReservaHotelService reservaHotelService;

    public ReservaHotelController(ReservaHotelService reservaHotelService) {
        this.reservaHotelService = reservaHotelService;
    }
    @PostMapping ("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva de hotel creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<?> crear (@RequestBody ReservaHotelDTO reservaHotelDTO){
        String response = reservaHotelService.guardar(reservaHotelDTO);
        if (!response.equals("El hotel no existe")||
                !response.equals("El ID de hotel no puede ser nulo. No se pudo crear.")) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Double.valueOf(response));
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

}

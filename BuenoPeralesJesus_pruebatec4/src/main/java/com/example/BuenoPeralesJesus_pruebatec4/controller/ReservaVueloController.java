package com.example.BuenoPeralesJesus_pruebatec4.controller;

import com.example.BuenoPeralesJesus_pruebatec4.dto.ReservaVueloDTO;
import com.example.BuenoPeralesJesus_pruebatec4.service.IReservaVueloService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agency/flight-booking")
public class ReservaVueloController {

    private final IReservaVueloService reservaVueloService;

    public ReservaVueloController(IReservaVueloService reservaVueloService) {
        this.reservaVueloService = reservaVueloService;
    }

    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva de vuelo creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<?> crear (@RequestBody ReservaVueloDTO reservaVueloDTO){
        String response = reservaVueloService.guardar(reservaVueloDTO);
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

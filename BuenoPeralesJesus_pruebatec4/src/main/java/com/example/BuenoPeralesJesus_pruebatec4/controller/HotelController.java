package com.example.BuenoPeralesJesus_pruebatec4.controller;

import com.example.BuenoPeralesJesus_pruebatec4.dto.HotelDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Hotel;
import com.example.BuenoPeralesJesus_pruebatec4.service.IHotelService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/hotels")
public class HotelController {

    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hotel creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<String> crear (@RequestBody HotelDTO hotelDTO){
        if (hotelDTO == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.guardarHotel(hotelDTO));
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente"),
            @ApiResponse(responseCode = "204", description = "No hay contenido")
    })
    public ResponseEntity<List<HotelDTO>> obtenerTodo(){
        if (hotelService.todoHotel().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(hotelService.todoHotel());
        }
        return ResponseEntity.ok(hotelService.todoHotel());
    }

    @GetMapping("/habitacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de habitaciones obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron habitaciones disponibles")
    })
    public ResponseEntity<List<HotelDTO>>obtenerFechaDireccion (@RequestParam ("fechaInicioDisponible")LocalDate fechaInicioDisponible,
                                                                @RequestParam ("fechaFinalDisponible") LocalDate fechaFinalDisponible ,
                                                                @RequestParam ("lugar")String lugar ){
        if(hotelService.todoHotelFechaDestino(fechaInicioDisponible,fechaFinalDisponible,lugar) == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(hotelService.todoHotelFechaDestino(fechaInicioDisponible,fechaFinalDisponible,lugar));
        }
        return ResponseEntity.ok(hotelService.todoHotelFechaDestino(fechaInicioDisponible,fechaFinalDisponible,lugar));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<String> editar (@PathVariable Long id , @RequestBody HotelDTO hotelDTO ){
        String response = hotelService.editalHotel(id , hotelDTO);
        if (response.equals("Se actualizó con éxito.")) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel eliminado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        String response = hotelService.eliminarHotel(id);
        if (response.equals("Se eliminó con éxito.")) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente"),
            @ApiResponse(responseCode = "204", description = "No hay contenido")
    })
    public ResponseEntity<Hotel> busquedaHotelId (@PathVariable Long id){
        if (hotelService.hotelId(id)== null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(hotelService.hotelId(id));
        }
        return ResponseEntity.ok(hotelService.hotelId(id));
    }
}

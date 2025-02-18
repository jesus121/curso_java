package com.example.BuenoPeralesJesus_pruebatec4.controller;

import com.example.BuenoPeralesJesus_pruebatec4.dto.VueloDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Vuelo;
import com.example.BuenoPeralesJesus_pruebatec4.service.IVueloService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class VueloController {

    private final IVueloService vueloService;

    public VueloController(IVueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vuelo creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<String> crear(@RequestBody VueloDTO vueloDTO) {
        if (vueloDTO == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vueloDTO);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.guardarVuelo(vueloDTO));
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de vuelos obtenida exitosamente"),
            @ApiResponse(responseCode = "204", description = "No hay contenido")
    })
    public ResponseEntity<List<VueloDTO>> obtenerTodo() {
        if (vueloService.todoVuelo().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vueloService.todoVuelo());
        }
        return ResponseEntity.ok(vueloService.todoVuelo());
    }

    @GetMapping("/Fecha")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de vuelos obtenida exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontraron vuelos")
    })
    public ResponseEntity<List<VueloDTO>> obtenerFechaDireccion(@RequestParam("fechaIda") LocalDate fechaIda,
                                                                @RequestParam("fechaVuelta") LocalDate fechaVuelta,
                                                                @RequestParam("destino") String destino,
                                                                @RequestParam("origen") String origen) {

        if(vueloService.todoVueloFechaDestino(fechaIda,fechaVuelta,destino,origen) == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(vueloService.todoVueloFechaDestino(fechaIda,fechaVuelta,destino,origen));
        }
        return ResponseEntity.ok(vueloService.todoVueloFechaDestino(fechaIda,fechaVuelta,destino,origen));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vuelo actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody VueloDTO vueloDTO) {
        String response = vueloService.editarVuelo(id, vueloDTO);
        if (response.equals("Se actualizó con éxito.")) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vuelo eliminado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        String response = vueloService.eliminarVuelo(id);
        if (response.equals("Se eliminó con éxito.")) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente"),
            @ApiResponse(responseCode = "204", description = "No hay contenido")
    })
    public ResponseEntity<Vuelo> busquedaVueloId (@PathVariable Long id){
        if (vueloService.vueloId(id)== null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vueloService.vueloId(id));
        }
        return ResponseEntity.ok(vueloService.vueloId(id));
    }
}

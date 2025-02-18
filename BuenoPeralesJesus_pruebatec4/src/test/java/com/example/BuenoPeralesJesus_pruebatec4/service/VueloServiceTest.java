package com.example.BuenoPeralesJesus_pruebatec4.service;

import com.example.BuenoPeralesJesus_pruebatec4.dto.VueloDTO;
import com.example.BuenoPeralesJesus_pruebatec4.model.Vuelo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VueloServiceTest {

    @Autowired
    private VueloService vueloService;

    @Test
    void testMapDtoToEntity() {
        // 1. Preparar los datos de prueba
        VueloDTO vueloDTO = new VueloDTO();
        vueloDTO.setNumeroVuelo("BA123");
        vueloDTO.setNombre("Vuelo de Prueba");
        vueloDTO.setOrigen("Madrid");
        vueloDTO.setDestino("Barcelona");
        vueloDTO.setTipoAsiento("Economy");
        vueloDTO.setPrecioVuelo(150.0);
        vueloDTO.setFechaIda(LocalDate.of(2024, 10, 1));
        vueloDTO.setFechaVuelta(LocalDate.of(2024, 10, 5));

        // 2. Ejecutar el método a probar
        Vuelo vuelo = vueloService.mapEntityToDto(vueloDTO);

        // 3. Verificar que los campos se mapearon correctamente
        assertNotNull(vuelo, "El objeto Vuelo no debería ser nulo");

        assertEquals("BA123", vuelo.getNumeroVuelo(), "El número de vuelo no coincide");
        assertEquals("Vuelo de Prueba", vuelo.getNombre(), "El nombre del vuelo no coincide");
        assertEquals("Madrid", vuelo.getOrigen(), "El origen no coincide");
        assertEquals("Barcelona", vuelo.getDestino(), "El destino no coincide");
        assertEquals("Economy", vuelo.getTipoAsiento(), "El tipo de asiento no coincide");
        assertEquals(150.0, vuelo.getPrecioVuelo(), "El precio del vuelo no coincide");
        assertEquals(LocalDate.of(2024, 10, 1), vuelo.getFechaIda(), "La fecha de ida no coincide");
        assertEquals(LocalDate.of(2024, 10, 5), vuelo.getFechaVuelta(), "La fecha de vuelta no coincide");
    }

    @Test
    void testMapEntityToDto() {
        // 1. Preparar los datos de prueba
        Vuelo vuelo = new Vuelo();
        vuelo.setNumeroVuelo("BA123");
        vuelo.setNombre("Vuelo de Prueba");
        vuelo.setOrigen("Madrid");
        vuelo.setDestino("Barcelona");
        vuelo.setTipoAsiento("Economy");
        vuelo.setPrecioVuelo(150.0);
        vuelo.setFechaIda(LocalDate.of(2024, 10, 1));
        vuelo.setFechaVuelta(LocalDate.of(2024, 10, 5));

        // 2. Ejecutar el método a probar
        VueloDTO vueloDTO = vueloService.mapDtoToEntity(vuelo);

        // 3. Verificar que los campos se mapearon correctamente
        assertNotNull(vueloDTO, "El objeto VueloDTO no debería ser nulo");

        assertEquals("BA123", vueloDTO.getNumeroVuelo(), "El número de vuelo no coincide");
        assertEquals("Vuelo de Prueba", vueloDTO.getNombre(), "El nombre del vuelo no coincide");
        assertEquals("Madrid", vueloDTO.getOrigen(), "El origen no coincide");
        assertEquals("Barcelona", vueloDTO.getDestino(), "El destino no coincide");
        assertEquals("Economy", vueloDTO.getTipoAsiento(), "El tipo de asiento no coincide");
        assertEquals(150.0, vueloDTO.getPrecioVuelo(), "El precio del vuelo no coincide");
        assertEquals(LocalDate.of(2024, 10, 1), vueloDTO.getFechaIda(), "La fecha de ida no coincide");
        assertEquals(LocalDate.of(2024, 10, 5), vueloDTO.getFechaVuelta(), "La fecha de vuelta no coincide");
    }

}

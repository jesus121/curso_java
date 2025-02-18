package com.example.BuenoPeralesJesus_pruebatec4.repository;

import com.example.BuenoPeralesJesus_pruebatec4.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

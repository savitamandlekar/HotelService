package com.in.hotel.controllers;

import com.in.hotel.Services.HotelService;
import com.in.hotel.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(service.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}

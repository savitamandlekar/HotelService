package com.in.hotel.Impl;

import com.in.hotel.Services.HotelService;
import com.in.hotel.entities.Hotel;
import com.in.hotel.exceptions.ResourceNotFoundException;
import com.in.hotel.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo repo;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return repo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return repo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found"));
    }
}

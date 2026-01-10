package com.example.systemBooking.service;

import com.example.systemBooking.entity.Reserva;

import java.util.List;

public interface IReservaService {
    public List<Reserva> findAll();
    public Reserva findById(Long id);
    public boolean exists(Long id);
    public boolean existsById(Long id);
    public Reserva save(Reserva reserva);
    public void deleteById(Long id);
}

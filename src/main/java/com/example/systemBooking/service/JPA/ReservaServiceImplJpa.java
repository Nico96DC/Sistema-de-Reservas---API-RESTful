package com.example.systemBooking.service.JPA;

import com.example.systemBooking.entity.Reserva;
import com.example.systemBooking.repository.ReservaRepository;
import com.example.systemBooking.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImplJpa implements IReservaService {
    @Autowired
    private ReservaRepository repository;

    @Override
    public List<Reserva> findAll() {
        return repository.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean exists(Long id) {
        return id != null && repository.existsById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

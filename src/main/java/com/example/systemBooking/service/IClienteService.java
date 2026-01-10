package com.example.systemBooking.service;

import com.example.systemBooking.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public boolean exists(Long id);
    public boolean existsById(Long id);
    public Cliente save(Cliente cliente);
    public void deleteById(Long id);
}

package com.example.systemBooking.repository;

import com.example.systemBooking.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);
    List<Cliente> findByApellido(String apellido);
    List<Cliente> findByNombreAndApellido(String nombre, String apellido);
    Optional<Cliente> findByEmail(String email);
    List<Cliente> findByTelefono(int telefono);
}

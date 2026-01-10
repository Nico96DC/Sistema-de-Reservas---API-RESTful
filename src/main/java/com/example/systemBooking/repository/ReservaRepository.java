package com.example.systemBooking.repository;

import com.example.systemBooking.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByFechaReserva(LocalDate fechaReserva);
    List<Reserva> findByHoraInicio(LocalTime horaInicio);
    List<Reserva> findByFechaReservaAndHoraInicio(LocalDate fechaReserva, LocalTime horaInicio);
    List<Reserva> findByEstado(String estado);
    List<Reserva> findByClienteId(Long clienteId);
}

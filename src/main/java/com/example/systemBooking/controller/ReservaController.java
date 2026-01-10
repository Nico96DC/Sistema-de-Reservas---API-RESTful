package com.example.systemBooking.controller;

import com.example.systemBooking.entity.Reserva;
import com.example.systemBooking.service.IReservaService;
import com.example.systemBooking.util.APIResponse;
import com.example.systemBooking.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/reservas/")
public class ReservaController {
    @Autowired
    private IReservaService reservaService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Reserva>>> getAllReservas() {
        List<Reserva> reservas = reservaService.findAll();
        return reservas.isEmpty()?
                ResponseUtil.notFound("Reservas no encontradas") :
                ResponseUtil.success(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Reserva>> getReservaById(@PathVariable("id") Long id) {
        return reservaService.existsById(id) ?
                ResponseUtil.success(reservaService.findById(id)) :
                ResponseUtil.notFound("No se encontró reserva con el id " + id);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Reserva>> createReserva(@RequestBody Reserva reserva) {
        if(reserva.getId() != null && reservaService.exists(reserva.getId())){
            return ResponseUtil.badRequest("La reserva ya existe");
        }
        return ResponseUtil.success(reservaService.save(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Reserva>> updateReserva(@PathVariable("id") Long id, @RequestBody Reserva reserva) {
        if (!reservaService.exists(id)) {
            return ResponseUtil.badRequest("No se encontró reserva con el id " + id);
        }
        reserva.setId(id);
        Reserva updatedReserva = reservaService.save(reserva);
        return ResponseUtil.success(updatedReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Reserva>> deleteReserva(@PathVariable("id") Long id) {
        if (!reservaService.exists(id)) {
            return ResponseUtil.badRequest("No se encontró reserva con el id " + id);
        } else {
            reservaService.deleteById(id);
            return ResponseUtil.successDeleted("Reserva " + id + " eliminada exitosamente", id);
        }
    }
}
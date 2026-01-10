package com.example.systemBooking.controller;

import com.example.systemBooking.entity.Cliente;
import com.example.systemBooking.service.IClienteService;
import com.example.systemBooking.util.APIResponse;
import com.example.systemBooking.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/clientes/")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Cliente>>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return clientes.isEmpty()?
                ResponseUtil.notFound("Clientes no encontrados") :
                ResponseUtil.success(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Cliente>> getClienteById(@PathVariable("id") Long id) {
        return clienteService.existsById(id) ?
                ResponseUtil.success(clienteService.findById(id)) :
                ResponseUtil.notFound("No se encontró cliente con el id " + id);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Cliente>> createCliente(@RequestBody Cliente cliente) {
        if (cliente.getId() != null && clienteService.exists(cliente.getId())) {
            return ResponseUtil.badRequest("El cliente ya existe");
        }
        return ResponseUtil.success(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Cliente>> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        if (!clienteService.exists(id)) {
            return ResponseUtil.badRequest("No se encontró cliente con el id " + id);
        }
        cliente.setId(id);
        Cliente updatedCliente = clienteService.save(cliente);
        return ResponseUtil.success(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Cliente>> deleteCliente(@PathVariable("id") Long id) {
        if (!clienteService.exists(id)) {
            return ResponseUtil.badRequest("No se encontró cliente con el id " + id);
        } else {
            clienteService.deleteById(id);
            return ResponseUtil.successDeleted("Cliente " + id + " eliminado exitosamente", id);
        }
    }
}
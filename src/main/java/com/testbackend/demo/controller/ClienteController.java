package com.testbackend.demo.controller;

import com.testbackend.demo.model.Cliente;
import com.testbackend.demo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    @GetMapping("/ordenados-nombre")
    public ResponseEntity<List<Cliente>> listarClientesPorNombre() {
        return ResponseEntity.ok(clienteService.listarClientesOrdenadosPorNombre());
    }

    @GetMapping("/ordenados-edad")
    public ResponseEntity<List<Cliente>> listarClientesPorEdad() {
        return ResponseEntity.ok(clienteService.listarClientesOrdenadosPorEdad());
    }
}

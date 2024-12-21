package com.testbackend.demo.controller;

import com.testbackend.demo.model.Cliente;
import com.testbackend.demo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/clientespornombre")
    public ResponseEntity<List<Cliente>> ClientesPorNombre() {
        return ResponseEntity.ok(clienteService.clientesPorNombre());
    }

    @GetMapping("/clientesporedad")
    public ResponseEntity<List<Map<String, Object>>> ClientesPorEdad() {
        return ResponseEntity.ok(clienteService.clientesPorEdad());
    }

    @GetMapping("/edadpromedio")
    public ResponseEntity<Map<String, Object>> EdadPromedio() {
        return ResponseEntity.ok(clienteService.promedioEdad());
    }
}

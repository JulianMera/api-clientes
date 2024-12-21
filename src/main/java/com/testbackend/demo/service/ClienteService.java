package com.testbackend.demo.service;

import com.testbackend.demo.model.Cliente;
import com.testbackend.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientesOrdenadosPorNombre() {
        return clienteRepository.findAll()
                .stream()
                .sorted((c1, c2) -> c1.getNombreCompleto().compareToIgnoreCase(c2.getNombreCompleto()))
                .toList();
    }

    public List<Cliente> listarClientesOrdenadosPorEdad() {
        return clienteRepository.findAll()
                .stream()
                .sorted((c1, c2) -> c1.getFechaNacimiento().compareTo(c2.getFechaNacimiento()))
                .toList();
    }
}

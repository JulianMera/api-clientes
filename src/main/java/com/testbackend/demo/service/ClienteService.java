package com.testbackend.demo.service;

import com.testbackend.demo.model.Cliente;
import com.testbackend.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> clientesPorNombre() {
        return clienteRepository.findAll()
                .stream()
                .sorted((c1, c2) -> c1.getNombreCompleto().compareToIgnoreCase(c2.getNombreCompleto()))
                .toList();
    }

    public List<Map<String, Object>> clientesPorEdad() {
        return clienteRepository.findAll()
                .stream()
                .sorted((c1, c2) -> Period.between(c1.getFechaNacimiento(), LocalDate.now())
                        .getYears() - Period.between(c2.getFechaNacimiento(), LocalDate.now()).getYears())
                .map(cliente -> {
                    Map<String, Object> resultado = Map.of(
                            "nombre", cliente.getNombreCompleto(),
                            "edad", Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears()
                    );
                    return resultado;
                })
                .collect(Collectors.toList());
    }

    public Map<String, Object> promedioEdad() {
        List<Cliente> clientes = clienteRepository.findAll();
        long cantidadClientes = clientes.size();
        double promedioEdad = clientes.stream()
                .mapToInt(cliente -> LocalDate.now().getYear() - cliente.getFechaNacimiento().getYear())
                .average()
                .orElse(0);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("Clientes", cantidadClientes);
        resultado.put("EdadPromedio", promedioEdad);
        return resultado;
    }
}

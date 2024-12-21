package com.testbackend.demo.config;

import com.testbackend.demo.model.Cliente;
import com.testbackend.demo.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ClienteRepository clienteRepository;

    public DataInitializer(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Cliente> clientes = List.of(
                new Cliente(null, "Juan Pérez", "123456789", "juan.perez@example.com", LocalDate.of(1990, 5, 15)),
                new Cliente(null, "Ana López", "987654321", "ana.lopez@example.com", LocalDate.of(1985, 3, 22)),
                new Cliente(null, "Pedro Sánchez", "456123789", "pedro.sanchez@example.com", LocalDate.of(2000, 8, 10)),
                new Cliente(null, "María Fernández", "789456123", "maria.fernandez@example.com", LocalDate.of(1995, 12, 5))
        );

        clienteRepository.saveAll(clientes);

        System.out.println("Clientes iniciales precargados");
    }
}

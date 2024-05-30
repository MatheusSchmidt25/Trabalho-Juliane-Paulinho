package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Cliente;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ClienteApiController {

    private final ClienteService clienteService;

    public ClienteApiController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/api/cliente")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @PostMapping(path = "/api/cliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @GetMapping(path = "/api/cliente/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.getById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/cliente/update/{id}")
    public ResponseEntity<Cliente> update(@PathVariable int id, @RequestBody Cliente cliente) {
        Optional<Cliente> existingCliente = clienteService.getById(id);
        if (existingCliente.isPresent()) {
            cliente.setId(id);
            Cliente updatedCliente = clienteService.save(cliente);
            return ResponseEntity.ok(updatedCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/cliente/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if (clienteService.getById(id).isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Cliente;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Sistema de Gerenciamento de Clientes", tags = "Gerenciamento de Clientes")
public class ClienteApiController {

    private final ClienteService clienteService;

    public ClienteApiController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ApiOperation(value = "Obter todos os clientes", response = List.class)
    @GetMapping(path = "/api/cliente")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @ApiOperation(value = "Adicionar um novo cliente", response = Cliente.class)
    @PostMapping(path = "/api/cliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @ApiOperation(value = "Obter um cliente pelo Id", response = Cliente.class)
    @GetMapping(path = "/api/cliente/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.getById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Atualizar um cliente existente", response = Cliente.class)
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

    @ApiOperation(value = "Deletar um cliente pelo Id")
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

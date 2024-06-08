package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;


import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.VendaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController

public class VendaApiController {

    private final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping(path = "/api/venda")
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(vendaService.getAll());
    }

    @PostMapping(path = "/api/venda")
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.save(venda));
    }

    @GetMapping(path = "/api/venda/{id}")
    public ResponseEntity<Venda> getById(@PathVariable int id) {
        Optional<Venda> venda = vendaService.getById(id);
        return venda.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/venda/update/{id}")
    public ResponseEntity<Venda> update(@PathVariable int id, @RequestBody Venda venda) {
        Optional<Venda> existingVenda = vendaService.getById(id);
        if (existingVenda.isPresent()) {
            venda.setId(id);
            Venda updatedVenda = vendaService.save(venda);
            return ResponseEntity.ok(updatedVenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/venda/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if (vendaService.getById(id).isPresent()) {
            vendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.ItemVenda;

import br.unipar.programacaoweb.trabalhojulianepaulinho.service.ItemVendaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ItemVendaApiController {

    private final ItemVendaService itemVendaService;

    public ItemVendaApiController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @GetMapping(path = "/api/itemVenda")
    public ResponseEntity<List<ItemVenda>> getAll() {
        return ResponseEntity.ok(itemVendaService.getAll());
    }

    @PostMapping(path = "/api/itemVenda")
    public ResponseEntity<ItemVenda> save(@RequestBody ItemVenda itemVenda){
        return ResponseEntity.ok(itemVendaService.save(itemVenda));
    }

    @GetMapping(path = "/api/itemVenda/{id}")
    public ResponseEntity<ItemVenda> getById(@PathVariable int id) {
        Optional<ItemVenda> itemVenda = itemVendaService.getById(id);
        return itemVenda.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/itemVenda/update/{id}")
    public ResponseEntity<ItemVenda> update(@PathVariable Integer id, @RequestBody ItemVenda itemVenda) {
        Optional<ItemVenda> existingVenda = itemVendaService.getById(id);
        if (existingVenda.isPresent()) {
            itemVenda.setId(id);
            ItemVenda updatedItemVenda = itemVendaService.save(itemVenda);
            return ResponseEntity.ok(updatedItemVenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/itemVenda/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if (itemVendaService.getById(id).isPresent()) {
            itemVendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

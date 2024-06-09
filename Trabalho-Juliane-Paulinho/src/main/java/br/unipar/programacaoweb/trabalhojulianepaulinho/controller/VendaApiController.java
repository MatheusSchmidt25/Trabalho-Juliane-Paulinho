package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Sistema de Gerenciamento de Vendas", tags = "Gerenciamento de Vendas")
public class VendaApiController {

    private final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @ApiOperation(value = "Obter todas as vendas", response = List.class)
    @GetMapping(path = "/api/venda")
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(vendaService.getAll());
    }

    @ApiOperation(value = "Adicionar uma nova venda", response = Venda.class)
    @PostMapping(path = "/api/venda")
    public ResponseEntity<Venda> save(@ApiParam(value = "Objeto venda que será armazenado no banco de dados", required = true) @RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.save(venda));
    }

    @ApiOperation(value = "Obter uma venda pelo Id", response = Venda.class)
    @GetMapping(path = "/api/venda/{id}")
    public ResponseEntity<Venda> getById(@ApiParam(value = "Id da venda que será recuperada", required = true) @PathVariable int id) {
        Optional<Venda> venda = vendaService.getById(id);
        return venda.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Atualizar uma venda existente", response = Venda.class)
    @PutMapping("/api/venda/update/{id}")
    public ResponseEntity<Venda> update(@ApiParam(value = "Id da venda para atualizar o objeto", required = true) @PathVariable int id,
                                        @ApiParam(value = "Objeto venda atualizado", required = true) @RequestBody Venda venda) {
        Optional<Venda> existingVenda = vendaService.getById(id);
        if (existingVenda.isPresent()) {
            venda.setId(id);
            Venda updatedVenda = vendaService.save(venda);
            return ResponseEntity.ok(updatedVenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Deletar uma venda pelo Id")
    @DeleteMapping(path = "/api/venda/{id}")
    public ResponseEntity<Void> deleteById(@ApiParam(value = "Id da venda que será deletada do banco de dados", required = true) @PathVariable int id) {
        if (vendaService.getById(id).isPresent()) {
            vendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

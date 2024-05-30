package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Produto;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController

public class ProdutoApiController {

    private final ProdutoService produtoService;

    public ProdutoApiController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(path = "/api/produto")
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoService.getAll());
    }

    @PostMapping(path = "/api/produto")
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @GetMapping(path = "/api/produto/{id}")
    public ResponseEntity<Produto> getById(@PathVariable int id) {
        Optional<Produto> produto = produtoService.getById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/produto/update/{id}")
    public ResponseEntity<Produto> update(@PathVariable int id, @RequestBody Produto produto) {
        Optional<Produto> existingProduto = produtoService.getById(id);
        if (existingProduto.isPresent()) {
            produto.setId(id);
            Produto updatedProduto = produtoService.save(produto);
            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/produto/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if (produtoService.getById(id).isPresent()) {
            produtoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

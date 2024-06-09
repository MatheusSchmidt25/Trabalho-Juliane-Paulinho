package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Produto;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Sistema de Gerenciamento de Produtos", tags = "Gerenciamento de Produtos")
public class ProdutoApiController {

    private final ProdutoService produtoService;

    public ProdutoApiController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @ApiOperation(value = "Obter todos os produtos", response = List.class)
    @GetMapping(path = "/api/produto")
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoService.getAll());
    }

    @ApiOperation(value = "Adicionar um novo produto", response = Produto.class)
    @PostMapping(path = "/api/produto")
    public ResponseEntity<Produto> save(@ApiParam(value = "Objeto produto que será armazenado no banco de dados", required = true) @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @ApiOperation(value = "Obter um produto pelo Id", response = Produto.class)
    @GetMapping(path = "/api/produto/{id}")
    public ResponseEntity<Produto> getById(@ApiParam(value = "Id do produto que será recuperado", required = true) @PathVariable int id) {
        Optional<Produto> produto = produtoService.getById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Atualizar um produto existente", response = Produto.class)
    @PutMapping("/api/produto/update/{id}")
    public ResponseEntity<Produto> update(@ApiParam(value = "Id do produto para atualizar o objeto", required = true) @PathVariable int id,
                                          @ApiParam(value = "Objeto produto atualizado", required = true) @RequestBody Produto produto) {
        Optional<Produto> existingProduto = produtoService.getById(id);
        if (existingProduto.isPresent()) {
            produto.setId(id);
            Produto updatedProduto = produtoService.save(produto);
            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Deletar um produto pelo Id")
    @DeleteMapping(path = "/api/produto/{id}")
    public ResponseEntity<Void> deleteById(@ApiParam(value = "Id do produto que será deletado do banco de dados", required = true) @PathVariable int id) {
        if (produtoService.getById(id).isPresent()) {
            produtoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

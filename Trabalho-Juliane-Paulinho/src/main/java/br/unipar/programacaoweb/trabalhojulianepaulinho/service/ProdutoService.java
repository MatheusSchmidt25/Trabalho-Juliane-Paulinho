package br.unipar.programacaoweb.trabalhojulianepaulinho.service;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Produto;
import br.unipar.programacaoweb.trabalhojulianepaulinho.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Operation(summary = "Obter todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados")
    public List<Produto> getAll(){
        return this.produtoRepository.findAll();
    }

    @Operation(summary = "Salvar produto", description = "Salva um novo produto")
    public Produto save(Produto produto){
        return this.produtoRepository.save(produto);
    }

    @Operation(summary = "Obter produto por ID", description = "Obtém um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public Optional<Produto> getById(int id){
        return this.produtoRepository.findById(id);
    }

    @Operation(summary = "Excluir produto por ID", description = "Exclui um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto excluído"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public void deleteById(int id){
        this.produtoRepository.deleteById(id);
    }

}

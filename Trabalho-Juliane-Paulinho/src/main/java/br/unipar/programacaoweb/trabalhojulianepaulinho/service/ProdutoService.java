package br.unipar.programacaoweb.trabalhojulianepaulinho.service;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Produto;
import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.repository.ProdutoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll(){
        return this.produtoRepository.findAll();
    }

    public Produto save(Produto produto){
        return this.produtoRepository.save(produto);
    }

    public Optional<Produto> getById(int id){
        return this.produtoRepository.findById(id);
    }

    public void deleteById(int id){
        this.produtoRepository.deleteById(id);
    }

}

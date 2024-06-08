package br.unipar.programacaoweb.trabalhojulianepaulinho.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.repository.VendaRepository;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAll(){
        return this.vendaRepository.findAll();
    }

    public Venda save(Venda venda){
        return this.vendaRepository.save(venda);
    }



    public Optional<Venda> getById(int id){
        return this.vendaRepository.findById(id);
    }

    public void deleteById(int id){
        this.vendaRepository.deleteById(id);
    }



}

package br.unipar.programacaoweb.trabalhojulianepaulinho.service;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.repository.VendaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    @Operation(summary = "Obter todas as vendas", description = "Retorna uma lista de todas as vendas cadastradas")
    public List<Venda> getAll(){
        return this.vendaRepository.findAll();
    }

    @Operation(summary = "Salvar venda", description = "Salva uma nova venda")
    public Venda save(Venda venda){
        return this.vendaRepository.save(venda);
    }

    @Operation(summary = "Obter venda por ID", description = "Obtém uma venda pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda encontrada"),
            @ApiResponse(responseCode = "404", description = "Venda não encontrada")
    })
    public Optional<Venda> getById(int id){
        return this.vendaRepository.findById(id);
    }

    @Operation(summary = "Excluir venda por ID", description = "Exclui uma venda pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Venda excluída"),
            @ApiResponse(responseCode = "404", description = "Venda não encontrada")
    })
    public void deleteById(int id){
        this.vendaRepository.deleteById(id);
    }

    @Operation(summary = "Filtrar vendas por data", description = "Retorna uma lista de vendas filtradas pela data")
    public List<Venda> findByData(String data) {
        return this.vendaRepository.findByData(data);
    }
}

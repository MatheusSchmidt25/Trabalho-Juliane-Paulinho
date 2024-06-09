package br.unipar.programacaoweb.trabalhojulianepaulinho.service;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.ItemVenda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.repository.ItemVendaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository){
        this.itemVendaRepository = itemVendaRepository;
    }

    @Operation(summary = "Obter todos os itens de venda", description = "Retorna uma lista de todos os itens de venda cadastrados")
    public List<ItemVenda> getAll(){
        return this.itemVendaRepository.findAll();
    }

    @Operation(summary = "Salvar item de venda", description = "Salva um novo item de venda")
    public ItemVenda save(ItemVenda itemVenda){
        return this.itemVendaRepository.save(itemVenda);
    }

    @Operation(summary = "Obter item de venda por ID", description = "Obtém um item de venda pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item de venda encontrado"),
            @ApiResponse(responseCode = "404", description = "Item de venda não encontrado")
    })
    public Optional<ItemVenda> getById(int id){
        return this.itemVendaRepository.findById(id);
    }

    @Operation(summary = "Excluir item de venda por ID", description = "Exclui um item de venda pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item de venda excluído"),
            @ApiResponse(responseCode = "404", description = "Item de venda não encontrado")
    })
    public void deleteById(int id){
        this.itemVendaRepository.deleteById(id);
    }

}

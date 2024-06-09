package br.unipar.programacaoweb.trabalhojulianepaulinho.service;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Cliente;
import br.unipar.programacaoweb.trabalhojulianepaulinho.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Operation(summary = "Obter todos os clientes", description = "Retorna uma lista de todos os clientes cadastrados")
    public List<Cliente> getAll(){
        return this.clienteRepository.findAll();
    }

    @Operation(summary = "Salvar cliente", description = "Salva um novo cliente")
    public Cliente save(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    @Operation(summary = "Obter cliente por ID", description = "Obtém um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public Optional<Cliente> getById(int id){
        return this.clienteRepository.findById(id);
    }

    @Operation(summary = "Excluir cliente por ID", description = "Exclui um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente excluído"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public void deleteById(int id){
        this.clienteRepository.deleteById(id);
    }

}

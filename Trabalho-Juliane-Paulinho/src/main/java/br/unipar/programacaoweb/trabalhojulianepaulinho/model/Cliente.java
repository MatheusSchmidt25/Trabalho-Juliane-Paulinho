package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "Modelo que representa um cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do cliente", example = "1")
    private Integer id;

    @Schema(description = "Nome do cliente", example = "João da Silva")
    private String nome;

    @Schema(description = "Telefone do cliente", example = "(11) 91234-5678")
    private String telefone;

    @Schema(description = "Email do cliente", example = "joao.silva@example.com")
    private String email;

}

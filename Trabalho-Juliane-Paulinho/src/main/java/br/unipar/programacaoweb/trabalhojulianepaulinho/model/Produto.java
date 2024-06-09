package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "Modelo que representa um produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do produto", example = "1")
    private Integer id;

    @Schema(description = "Descrição do produto", example = "Camiseta 100% algodão")
    private String descricao;

    @Schema(description = "Valor do produto", example = "29.99")
    private Double valor;

    @Schema(description = "Categoria do produto", example = "Roupas")
    private String categoria;

}

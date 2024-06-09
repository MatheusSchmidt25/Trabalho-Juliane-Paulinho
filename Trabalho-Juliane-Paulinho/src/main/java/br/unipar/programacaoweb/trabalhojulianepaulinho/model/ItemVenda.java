package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Schema(description = "Modelo que representa um item de venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do item de venda", example = "1")
    private Integer id;

    @Schema(description = "Quantidade de produtos vendidos", example = "3")
    private int quantidade;

    @Schema(description = "Valor unitário do produto vendido", example = "29.99")
    private double valorUnitario;

    @Schema(description = "Valor total do item de venda", example = "89.97")
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    @Schema(description = "Venda associada a este item de venda")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @Schema(description = "Produto associado a este item de venda")
    private Produto produto;
}

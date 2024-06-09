package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Schema(description = "Modelo que representa uma venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da venda", example = "1")
    private Integer id;

    @Schema(description = "Observações sobre a venda", example = "Venda realizada com desconto especial")
    private String observacoes;

    @Schema(description = "Data da venda", example = "2023-06-09")
    private String data;

    @Schema(description = "Total da venda", example = "150.00")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @Schema(description = "Cliente associado a esta venda")
    private Cliente cliente;

}

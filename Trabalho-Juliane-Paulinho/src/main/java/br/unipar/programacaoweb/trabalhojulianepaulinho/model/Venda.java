package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String observacoes;

    private String data ;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id" )
    private Cliente cliente;



}

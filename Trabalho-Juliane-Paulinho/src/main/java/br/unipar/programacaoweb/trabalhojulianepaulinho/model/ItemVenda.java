package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;

@Entity
@Getter
@Setter
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quantidade;

    private double valorUnitario;

    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "venda_id" )
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id" )
    private Produto produto;



}

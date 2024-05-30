package br.unipar.programacaoweb.trabalhojulianepaulinho.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quantidade;

    private double valorUnitario;

    private double valorTotal;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;

}

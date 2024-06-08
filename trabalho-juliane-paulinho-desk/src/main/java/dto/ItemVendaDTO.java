/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author aluno
 */
public class ItemVendaDTO {

    private Integer id;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private VendaDTO venda;
    private ProdutoDTO produto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public VendaDTO getVenda() {
        return venda;
    }

    public void setVenda(VendaDTO venda) {
        this.venda = venda;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "ItemVendaDTO{" + "id=" + id + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", vendaID=" + venda + ", produtoID=" + produto + '}';
    }

}

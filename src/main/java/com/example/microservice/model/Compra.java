package com.example.microservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Compra {
    private String id;
    private List<ItemCompra> itens;
    private Cliente cliente;   // Cliente que fez a compra
    private Produto produto;   // Produto comprado
    private int quantidade;    // Quantidade comprada
    private double valorTotal; // Valor total da compra (quantidade * preço do produto)
    private int ano;           // Ano da compra

    public void calcularValorTotal(List<Produto> produtos) {
        valorTotal = itens.stream()
                .mapToDouble(item -> {
                    Produto produto = produtos.stream()
                            .filter(p -> p.getId().equals(item.getProdutoId()))
                            .findFirst()
                            .orElse(null);
                    return produto != null ? produto.getPreco() * item.getQuantidade() : 0;
                })
                .sum();
    }

    public int getAno() {
        return Integer.parseInt(id.substring(0, 4)); // Supondo que o ID começa com o ano da compra
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}


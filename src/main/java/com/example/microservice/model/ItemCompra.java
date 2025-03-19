package com.example.microservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCompra {
    private String produtoId;
    private int quantidade;

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

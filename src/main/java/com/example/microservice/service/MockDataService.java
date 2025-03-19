package com.example.microservice.service;

import com.example.microservice.model.Cliente;
import com.example.microservice.model.Compra;
import com.example.microservice.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockDataService {

    public List<Compra> getCompras() {
        // Retorna uma lista simulada de compras
        List<Compra> compras = new ArrayList<>();
        // Aqui adicionamos compras fictícias para testes
        return compras;
    }

    public List<Cliente> getClientes() {
        // Retorna uma lista simulada de clientes
        return new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        // Retorna uma lista simulada de produtos
        return new ArrayList<>();
    }
}


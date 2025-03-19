package com.example.microservice.controller;

import com.example.microservice.model.Cliente;
import com.example.microservice.model.Compra;
import com.example.microservice.model.Produto;
import com.example.microservice.service.DataService;
import com.example.microservice.service.MockDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CompraController {
    private final DataService dataService;

    public CompraController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/compras")
    public List<Compra> getCompras() {
        List<Cliente> clientes = dataService.fetchClientes();
        List<Produto> produtos = dataService.fetchProdutos();
        List<Compra> compras = new ArrayList<>();

        for (Cliente cliente : clientes) {
            for (Compra compra : cliente.getCompras()) {
                compra.setValorTotal(0);
                compra.calcularValorTotal(produtos);
                compras.add(compra);
            }
        }

        return compras.stream()
                .sorted(Comparator.comparing(Compra::getValorTotal))
                .collect(Collectors.toList());
    }

    @GetMapping("/maior-compra/{ano}")
    public Compra getMaiorCompra(@PathVariable int ano) {
        return getCompras().stream()
                .filter(c -> c.getAno() == ano)
                .max(Comparator.comparing(Compra::getValorTotal))
                .orElse(null);
    }

    @GetMapping("/clientes-fieis")
    public List<Cliente> getClientesFieis() {
        List<Cliente> clientes = dataService.fetchClientes();

        return clientes.stream()
                .sorted(Comparator.comparing(Cliente::getTotalGasto).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // 4. Recomendação de vinho com base no tipo mais comprado pelo cliente
    @GetMapping("/recomendacao/cliente/{tipo}")
    public List<Produto> recomendacaoVinho(@PathVariable String tipo) {
        MockDataService mockDataService = null;
        List<Produto> produtos = mockDataService.getProdutos();  // Obtém a lista de produtos

        // Filtra os produtos de acordo com o tipo solicitado
        return produtos.stream()
                .filter(produto -> produto.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
}



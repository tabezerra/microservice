package com.example.microservice.service;

import com.example.microservice.model.Cliente;
import com.example.microservice.model.Produto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DataService {
    private static final String PRODUTOS_URL = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json";
    private static final String CLIENTES_URL = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json";

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Produto> fetchProdutos() {
        Produto[] produtos = restTemplate.getForObject(PRODUTOS_URL, Produto[].class);
        return Arrays.asList(produtos);
    }

    public List<Cliente> fetchClientes() {
        Cliente[] clientes = restTemplate.getForObject(CLIENTES_URL, Cliente[].class);
        return Arrays.asList(clientes);
    }
}

package com.fun.clientcoreapi.controller;

import com.fun.clientcoreapi.data.entities.Client;
import com.fun.clientcoreapi.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(
    ) {
        return clientService.getAllClients();
    }

    @PostMapping
    public Client createClient(
            @RequestBody @Valid Client client
    ) {
        return clientService.createClient(client);
    }

    @PutMapping
    public Client updateClient(
            @RequestBody @Valid Client client
    ) {
        return clientService.createClient(client);
    }

}

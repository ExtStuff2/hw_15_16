package com.fun.clientcoreapi.controller;

import com.fun.clientcoreapi.data.entities.Client;
import com.fun.clientcoreapi.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/check")
    public String checkClientService() {
        return "client service is working";
    }

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

    @DeleteMapping
    public void deleteClient(@RequestBody @Valid Client client) {
        clientService.deleteClient(client);
    }

    @DeleteMapping("/delete/{clientId}")
    public void deleteClientById(@PathVariable UUID clientId) {
        clientService.deleteClientById(clientId);
    }

    @GetMapping("/{clientId}")
    public Client findClientById(@PathVariable UUID clientId) {
        return clientService.findClientById(clientId);
    }

}

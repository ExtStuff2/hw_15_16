package com.fun.postofficeapi.controllers;


import com.fun.postofficeapi.models.Client;
import com.fun.postofficeapi.proxy.PostClientsProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PostClientsController {

    private final PostClientsProxy postClientsProxy;

    public PostClientsController(PostClientsProxy postClientsProxy) {
        this.postClientsProxy = postClientsProxy;
    }


    @GetMapping("/clients")
    public List<Client> getAllPostClients() {
        return postClientsProxy.getClients().getBody();
    }

    @GetMapping("/clients/{clientId}")
    public Client getClientById(@PathVariable UUID clientId) {
        return postClientsProxy.getClientById(clientId).getBody();
    }

    @GetMapping("clients/check")
    public String checkClient() {
        return postClientsProxy.checkClient().getBody();
    }
}

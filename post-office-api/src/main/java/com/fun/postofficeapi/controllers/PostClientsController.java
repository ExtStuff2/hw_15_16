package com.fun.postofficeapi.controllers;


import com.fun.postofficeapi.models.Client;
import com.fun.postofficeapi.proxy.PostClientsProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

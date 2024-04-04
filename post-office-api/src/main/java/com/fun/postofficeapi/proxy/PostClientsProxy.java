package com.fun.postofficeapi.proxy;

import com.fun.postofficeapi.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "clients", url = "http://localhost:8082")
public interface PostClientsProxy {

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getClients();

    @GetMapping("/clients/{clientId}")
    ResponseEntity<Client> getClientById(@PathVariable UUID clientId);

    @GetMapping("/clients/check")
    ResponseEntity<String> checkClient();

}

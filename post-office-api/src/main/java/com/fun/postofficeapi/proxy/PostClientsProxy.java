package com.fun.postofficeapi.proxy;

import com.fun.postofficeapi.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "clients", url = "http://localhost:8082")
public interface PostClientsProxy {

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getClients();

}

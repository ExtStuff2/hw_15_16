package com.fun.clientcoreapi.service;

import com.fun.clientcoreapi.data.entities.Client;
import com.fun.clientcoreapi.data.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client createClient(Client request) {
         return clientRepository.save(request);
    }
    public Client findClientById(UUID clientId)
    {
        return clientRepository.getReferenceById(clientId);
    }

    public Client updateClientById(Client client)
    {
        if(clientRepository.existsById(client.getClientId()))
        {
            return clientRepository.save(client);
        }
        return new Client();
    }


}


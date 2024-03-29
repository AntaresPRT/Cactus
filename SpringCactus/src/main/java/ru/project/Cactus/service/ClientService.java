package ru.project.Cactus.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.project.Cactus.DTO.ClientDTO;
import ru.project.Cactus.entity.Client;
import ru.project.Cactus.reposiroty.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final Logger logger = LoggerFactory.getLogger(ClientService.class);
    private final ClientRepository clientRepository;

    public void save(ClientDTO clientDTO) {
        clientRepository.save(Client.builder()
                .firstname(clientDTO.getFirstname())
                .lastname(clientDTO.getLastname())
                .middle_name(clientDTO.getMiddle_name())
                .inn(clientDTO.getInn())
                .series(clientDTO.getSeries())
                .number(clientDTO.getNumber())
                .email(clientDTO.getEmail())
                .password(clientDTO.getPassword())
                .build());
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void update(int id,ClientDTO updatedClientDTO) {
        clientRepository.save(toClient(id,updatedClientDTO));
    }

    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    private Client toClient(int id,ClientDTO updatedClientDTO) {
        Client client = clientRepository.findById(id).orElse(null);
        assert client != null;
        client.setFirstname(updatedClientDTO.getFirstname());
        client.setLastname(updatedClientDTO.getLastname());
        client.setMiddle_name(updatedClientDTO.getMiddle_name());
        client.setInn(updatedClientDTO.getInn());
        client.setSeries(updatedClientDTO.getSeries());
        client.setNumber(updatedClientDTO.getNumber());
        client.setEmail(updatedClientDTO.getEmail());
        client.setPassword(updatedClientDTO.getPassword());
        return client;
    }
}

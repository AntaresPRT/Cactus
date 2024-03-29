package ru.project.Cactus.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.project.Cactus.DTO.ClientDTO;
import ru.project.Cactus.entity.Client;
import ru.project.Cactus.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;
    @PostMapping("/add")
    public void saveClient(@RequestBody ClientDTO clientDTO) {
        logger.info("Add new client");
        clientService.save(clientDTO);
    }

    @GetMapping("/findAll")
    public List<Client> findAll() {
        logger.info("Find all client");
        return clientService.findAll();
    }

    @GetMapping("/findById")
    public Client findById(@RequestParam int id) {
        logger.info("Find client by id: {}", id);
        return clientService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void updateClient(@PathVariable("id") int id,@RequestBody ClientDTO clientDTO) {
        logger.info("Update client by id: {}", id);
        clientService.update(id,clientDTO);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestParam int id) {
        logger.info("Delete client by id: {}", id);
        clientService.delete(id);
    }
}

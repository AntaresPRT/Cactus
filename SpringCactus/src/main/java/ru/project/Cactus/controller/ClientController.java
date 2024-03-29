package ru.project.Cactus.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "client_methods")
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;
    @PostMapping("/add")
    public void save(@RequestBody ClientDTO clientDTO) {
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
    public void update(@PathVariable("id") int id,@RequestBody ClientDTO clientDTO) {
        logger.info("Update client by id: {}", id);
        clientService.update(id,clientDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        logger.info("Delete client by id: {}", id);
        clientService.delete(id);
    }
}

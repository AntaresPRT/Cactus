package ru.project.Cactus.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.project.Cactus.DTO.ClientDTO;
import ru.project.Cactus.DTO.ContractDTO;
import ru.project.Cactus.entity.Client;
import ru.project.Cactus.entity.Contract;
import ru.project.Cactus.service.ContractService;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
@RequiredArgsConstructor
@Tag(name = "contact_methods")
public class ContractController {
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ContractService contractService;

    @PostMapping("/add")
    public void save(@RequestBody Contract contract) {
        logger.info("Add new contract");
        contractService.save(contract);
    }

    @GetMapping("/findAll")
    public List<Contract> findAll() {
        logger.info("Find all contracts");
        return contractService.findAll();
    }

    @GetMapping("/findById")
    public Contract findById(@RequestParam int id) {
        logger.info("Find contract by id: {}", id);
        return contractService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id,@RequestBody ContractDTO contractDTO) {
        logger.info("Update contract by id: {}", id);
        contractService.update(id,contractDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        logger.info("Delete contract by id: {}", id);
        contractService.delete(id);
    }
}

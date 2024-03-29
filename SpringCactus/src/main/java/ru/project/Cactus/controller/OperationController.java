package ru.project.Cactus.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.project.Cactus.DTO.OperationDTO;
import ru.project.Cactus.entity.Operation;
import ru.project.Cactus.service.OperationService;

import java.util.List;

@RestController
@RequestMapping("/api/operation")
@RequiredArgsConstructor
@Tag(name = "operation_methods")
public class OperationController {
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final OperationService operationService;

    @PostMapping("/add")
    public void save(@RequestBody OperationDTO operationDTO) {
        logger.info(operationDTO.getTypeOper().name());
        logger.info("Add new operation");
        operationService.save(operationDTO);
    }

    @GetMapping("/findAll")
    public List<Operation> findAll() {
        logger.info("Find all operations");
        return operationService.findAll();
    }

    @GetMapping("/findById")
    public Operation findById(@RequestParam int id) {
        logger.info("Find operation by id: {}", id);
        return operationService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id,@RequestBody OperationDTO operationDTO) {
        logger.info("Update operation by id: {}", id);
        operationService.update(id,operationDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        logger.info("Delete operation by id: {}", id);
        operationService.delete(id);
    }
}

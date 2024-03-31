package ru.project.Cactus.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.project.Cactus.DTO.AccountDTO;
import ru.project.Cactus.DTO.ContractDTO;
import ru.project.Cactus.DTO.OperationDTO;
import ru.project.Cactus.entity.Account;
import ru.project.Cactus.entity.Client;
import ru.project.Cactus.entity.Contract;
import ru.project.Cactus.enumeration.Oper;
import ru.project.Cactus.service.AccountService;
import ru.project.Cactus.service.ClientService;
import ru.project.Cactus.service.ContractService;
import ru.project.Cactus.service.OperationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Tag(name = "account_methods")
public class AccountController {
    private final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;
    private final OperationService operationService;
    private final ContractService contractService;
    private final ClientService clientService;

    @PostMapping("/add")
    public void save(@RequestBody AccountDTO accountDTO) {
        logger.info("Add new account");
        //contractService.save(new ContractDTO(clientService.findById(9), LocalDate.now(),LocalDate.now().plusYears(8)));
        operationService.save(new OperationDTO(Oper.OPEN,null,accountDTO.getContract()));
        accountService.save(accountDTO);
    }

    @GetMapping("/findAll")
    public List<Account> findAll() {
        logger.info("Find all accounts");
        return accountService.findAll();
    }

    @GetMapping("/findById")
    public Account findById(@RequestParam int id) {
        logger.info("Find account by id: {}", id);
        return accountService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id,@RequestBody AccountDTO accountDTO) {
        logger.info("Update account by id: {}", id);
        accountService.update(id,accountDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        logger.info("Delete account by id: {}", id);
        accountService.delete(id);
    }

    @GetMapping("/getBalance/{id}")
    public BigDecimal getBalance(@PathVariable int id) {
        logger.info("Get balance by account id: {}", id);
        Account account = accountService.findById(id);
        return operationService.getBalance(account.getContract().getId());
    }


}

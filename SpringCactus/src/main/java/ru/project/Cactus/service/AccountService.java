package ru.project.Cactus.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.project.Cactus.DTO.AccountDTO;
import ru.project.Cactus.entity.Account;
import ru.project.Cactus.reposiroty.AccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final Logger logger = LoggerFactory.getLogger(AccountService.class);
    public void save(AccountDTO accountDTO) {
        accountRepository.customInsert(accountDTO.getContract().getId(),
                accountDTO.getCurr().name(),
                accountDTO.getNumber()
        );
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    public void update(int id,AccountDTO updatedAccountDTO) {
        accountRepository.save(toAccount(id,updatedAccountDTO));
    }

    public void delete(int id) {
        accountRepository.deleteById(id);
    }

    private Account toAccount(int id,AccountDTO updatedAccountDTO) {
        Account account = accountRepository.findById(id).orElse(null);
        assert account != null;
        account.setContract(updatedAccountDTO.getContract());
        account.setNumber(updatedAccountDTO.getNumber());
        account.setCurr(updatedAccountDTO.getCurr());
        return account;
    }
}

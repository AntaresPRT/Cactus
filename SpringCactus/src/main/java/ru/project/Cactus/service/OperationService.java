package ru.project.Cactus.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.project.Cactus.DTO.OperationDTO;
import ru.project.Cactus.entity.Operation;
import ru.project.Cactus.enumeration.Oper;
import ru.project.Cactus.reposiroty.OperationRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;
    private final Logger logger = LoggerFactory.getLogger(OperationService.class);
    public void save(OperationDTO operationDTO) {
        operationRepository.customInsert(operationDTO.getContract().getId(),
                operationDTO.getSumm(),
                operationDTO.getTypeOper().name());
    }


    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Operation findById(int id) {
        return operationRepository.findById(id).orElse(null);
    }

    public void update(int id,OperationDTO updatedOperationDTO) {
        operationRepository.save(toOperation(id,updatedOperationDTO));
    }

    public void delete(int id) {
        operationRepository.deleteById(id);
    }

    private Operation toOperation(int id,OperationDTO updatedOperationDTO) {
        Operation operation = operationRepository.findById(id).orElse(null);
        assert operation != null;
        operation.setTypeOper(updatedOperationDTO.getTypeOper());
        operation.setSumm(updatedOperationDTO.getSumm());
        operation.setContract(updatedOperationDTO.getContract());
        return operation;
    }

    public BigDecimal getBalance(int ncontract) {
        List<Operation> operations = operationRepository.findAllByContractId(ncontract);
        BigDecimal balance = BigDecimal.ZERO;

        for (Operation operation : operations) {
            if (operation.getTypeOper() == Oper.REPLENISHMENT) {
                balance = balance.add(operation.getSumm());
            } else if (operation.getTypeOper() == Oper.WITHDRAWAL) {
                balance = balance.subtract(operation.getSumm());
            }
        }

        return balance;
    }
}

package ru.project.Cactus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.Cactus.DTO.ClientDTO;
import ru.project.Cactus.DTO.ContractDTO;
import ru.project.Cactus.entity.Client;
import ru.project.Cactus.entity.Contract;
import ru.project.Cactus.reposiroty.ContractRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    public void update(int id,ContractDTO updatedContractDTO) {
        contractRepository.save(toContract(id,updatedContractDTO));
    }

    public void delete(int id) {
        contractRepository.deleteById(id);
    }

    private Contract toContract(int id,ContractDTO updatedContractDTO) {
        Contract contract = contractRepository.findById(id).orElse(null);
        assert contract != null;
        contract.setClient(updatedContractDTO.getClient());
        contract.setDateopen(updatedContractDTO.getDateopen());
        contract.setDateclose(updatedContractDTO.getDateclose());
        return contract;
    }
}

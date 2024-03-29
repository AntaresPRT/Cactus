package ru.project.Cactus.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.Cactus.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
}

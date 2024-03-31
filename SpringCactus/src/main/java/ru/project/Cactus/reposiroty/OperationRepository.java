package ru.project.Cactus.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.project.Cactus.entity.Operation;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.operation (ncontract, summ, type_oper) VALUES (:ncontract, :summ, CAST(:type_oper AS oper))", nativeQuery = true)
    void customInsert(@Param("ncontract") int ncontract, @Param("summ") BigDecimal summ, @Param("type_oper") String typeOper);

    @Query("SELECT o FROM Operation o WHERE o.contract.id = :contractId")
    List<Operation> findAllByContractId(int contractId);
}

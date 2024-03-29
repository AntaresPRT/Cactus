package ru.project.Cactus.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.project.Cactus.entity.Account;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.account (ncontract, curr, number) VALUES (:ncontract, CAST(:curr AS currency), :number)", nativeQuery = true)
    void customInsert(@Param("ncontract") int ncontract, @Param("curr") String typeCurr, @Param("number") String number);
}

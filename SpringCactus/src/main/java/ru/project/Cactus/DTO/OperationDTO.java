package ru.project.Cactus.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.project.Cactus.entity.Contract;
import ru.project.Cactus.enumeration.Oper;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationDTO {
    Oper typeOper;
    BigDecimal summ;
    Contract contract;
}

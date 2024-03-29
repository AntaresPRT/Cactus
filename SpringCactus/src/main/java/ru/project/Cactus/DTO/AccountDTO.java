package ru.project.Cactus.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.project.Cactus.entity.Contract;
import ru.project.Cactus.enumeration.Currency;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDTO {
    Contract contract;
    String number;
    Currency curr;
}

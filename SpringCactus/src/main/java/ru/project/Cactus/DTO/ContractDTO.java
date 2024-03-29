package ru.project.Cactus.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.project.Cactus.entity.Client;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContractDTO {
    Client client;
    LocalDate dateopen;
    LocalDate dateclose;
}

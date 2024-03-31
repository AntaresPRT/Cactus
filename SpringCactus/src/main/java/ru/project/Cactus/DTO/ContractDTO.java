package ru.project.Cactus.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.project.Cactus.entity.Client;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContractDTO {
    Client client;
    LocalDate dateopen;
    LocalDate dateclose;
}

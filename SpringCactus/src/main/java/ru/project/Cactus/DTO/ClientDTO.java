package ru.project.Cactus.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDTO {
    String firstname;
    String lastname;
    String middle_name;
    String inn;
    String series;
    String number;
    String email;
    String password;
}

package ru.project.Cactus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clientid",referencedColumnName = "id")
    @JsonBackReference
    private Client client;
    private LocalDate dateopen;
    private LocalDate dateclose;

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private List<Account> accountList;

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private List<Operation> operations;

}

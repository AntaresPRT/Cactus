package ru.project.Cactus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import ru.project.Cactus.enumeration.Currency;
@Entity
@Table(name = "account")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ncontract",referencedColumnName = "id")
    @JsonBackReference
    private Contract contract;
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "curr")
    private Currency curr;
}

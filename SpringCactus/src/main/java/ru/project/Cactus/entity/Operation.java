package ru.project.Cactus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.project.Cactus.enumeration.Oper;

import java.math.BigDecimal;

@Entity
@Table(name = "operation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_oper")
    private Oper typeOper;

    private BigDecimal summ;

    @ManyToOne
    @JoinColumn(name = "ncontract",referencedColumnName = "id")
    @JsonBackReference
    private Contract contract;
}

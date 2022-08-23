package com.hamza.gametransactionapi.models;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @OneToMany(mappedBy = "transaction", cascade=CascadeType.ALL)
    private List<Product> products;

    @Column(name = "user_id")
    private Long userId;

    private BigDecimal amount;

}

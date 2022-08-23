package com.hamza.gametransactionapi.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long productId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="transaction_id", insertable = false, updatable = false)
    private Transaction transaction;

}

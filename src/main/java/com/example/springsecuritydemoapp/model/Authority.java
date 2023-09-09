package com.example.springsecuritydemoapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authorities")
@Getter
@Setter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator ="native")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

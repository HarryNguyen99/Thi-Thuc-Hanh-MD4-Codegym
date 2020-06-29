package com.example.thithuchanhmd4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "nations")
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String nameNation;
}

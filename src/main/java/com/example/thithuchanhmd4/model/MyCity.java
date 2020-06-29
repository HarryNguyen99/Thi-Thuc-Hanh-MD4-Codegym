package com.example.thithuchanhmd4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "citys")
public class MyCity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double area;
    @Column(nullable = false)
    private Long population;
    @Column(nullable = false)
    private double gdp;
    @Column(columnDefinition = "long")
    private String description;

    @ManyToOne
    private Nation nation;
}

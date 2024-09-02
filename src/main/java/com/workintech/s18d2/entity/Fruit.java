package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "fruit", schema = "public")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String name;


    private Double price;

    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
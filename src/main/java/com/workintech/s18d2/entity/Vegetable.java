package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema = "public")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Min(value = 1, message = "boş değer olamaz")
    private Long id;
    private String name;
    private Double price;
    @Column(name = "is_grown_on_tree")
    private Boolean isGrownOnTree;

    public void setGrownOnTree(Boolean grownOnTree) {
        isGrownOnTree = grownOnTree;
    }

    public Boolean isGrownOnTree(){
        return this.isGrownOnTree;
    }
}
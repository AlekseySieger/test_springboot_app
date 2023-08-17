package com.car_sales_company.car_app.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, name = "weight_kg")
    private Double weightKg;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, length = 256, name = "type_of_wool")
    private String typeOfWool;

    private Long age;

    @Column(nullable = false, name = "owners_number", length = 55)
    private String ownersNumber;

    private Boolean active;
}

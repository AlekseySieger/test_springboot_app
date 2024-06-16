package com.car_sales_company.car_app.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Car> car;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, length = 256, name = "second_name")
    private String secondName;

    @Column(nullable = false)
    private short age;


}

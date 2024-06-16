package com.car_sales_company.car_app.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "garage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false, length = 256)
    private String material;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false,name = "size")
    private Long size;

    @Column(nullable = false, name = "parking_space")
    private Long parking_space;

}

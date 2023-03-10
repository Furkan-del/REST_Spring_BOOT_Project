package com.example.trial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mechanicers")
public class Mechanicer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Price")
    private Integer price;

    @OneToMany(mappedBy = "mechanicerr")
    private List<Car> car;
    @OneToMany(mappedBy = "mechanicer")
    private  List<Gallery>galleries;
}

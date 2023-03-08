package com.example.trial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "plate",unique = true)
    private String plate;
    @Column(name = "daily_price")
    private Integer dailyPrice;
    @Column(name = "model_year")
    private Long modelYear;
    @Column(name = "state")
    private Integer state; //1 - available 2-rented 3-

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @ManyToOne
    @JoinColumn(name = "galery_id")
    private Gallery gallery;

}

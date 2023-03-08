package com.example.trial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brands")
public class Brand  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="brand_name")
    private String name;
// buraya yazılacak şey ilişki ismi tamamen olduğum tabloyla referans aldığı nesne arasında olur  olduğum nesen ilk yazılır

}

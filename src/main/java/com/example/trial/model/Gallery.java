package com.example.trial.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gallerys")
public class Gallery {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "distance")
    private Integer distance;
    @Column(name = "totalAmount")
    private Integer totalAmount;

    @ManyToOne
    @JoinColumn(name = "mechanicer_id")
    private Mechanicer mechanicer;
}

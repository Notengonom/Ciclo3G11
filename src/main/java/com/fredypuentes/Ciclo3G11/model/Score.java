package com.fredypuentes.Ciclo3G11.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String messageText;

    private Integer stars;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;
}

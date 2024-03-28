package com.microservice.catalog.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @ManyToOne(targetEntity = State.class)
    @JsonIgnore
    private State state;

    @OneToMany(targetEntity = Neighborhood.class, fetch = FetchType.LAZY, mappedBy = "city")
    @JsonIgnore
    private List<Neighborhood> neighborhoods = new ArrayList<>();
}


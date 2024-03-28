package com.microservice.catalog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "states")
@AllArgsConstructor
@NoArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @ManyToOne(targetEntity = Country.class)
    @JsonIgnore
    private Country country;

    @OneToMany(targetEntity = City.class, fetch = FetchType.LAZY, mappedBy = "state")
    @JsonIgnore
    private List<City> cities = new ArrayList<>();
}

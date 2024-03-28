package com.microservice.catalog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(targetEntity = State.class, fetch = FetchType.LAZY, mappedBy = "country")
    @JsonIgnore
    private List<State> states = new ArrayList<>();
}

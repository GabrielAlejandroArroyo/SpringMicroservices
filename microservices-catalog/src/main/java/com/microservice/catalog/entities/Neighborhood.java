package com.microservice.catalog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "neighborhoods")
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @ManyToOne(targetEntity = City.class)
    @JsonIgnore
    private City city;
}

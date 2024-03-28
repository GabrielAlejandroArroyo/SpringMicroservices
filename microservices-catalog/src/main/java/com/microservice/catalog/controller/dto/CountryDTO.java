package com.microservice.catalog.controller.dto;

import com.microservice.catalog.entities.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDTO {
    private Long id;
    private String name;
    private List<State> states = new ArrayList<>();
}

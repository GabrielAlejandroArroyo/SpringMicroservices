package com.microservice.catalog.controller;

import com.microservice.catalog.controller.dto.NeighborhoodDTO;
import com.microservice.catalog.entities.Neighborhood;
import com.microservice.catalog.service.INeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog/neighborhood")
public class NeighborhoodController {
    @Autowired
    private INeighborhoodService neighborhoodService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Neighborhood neighborhood){
        neighborhoodService.save(neighborhood);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
        List<NeighborhoodDTO> neighborhoods= neighborhoodService.findAll()
                .stream()
                .map(neighborhood -> NeighborhoodDTO.builder()
                        .id(neighborhood.getId())
                        .name(neighborhood.getName())
                        .build())
                .toList();

        return ResponseEntity.ok(neighborhoods);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById( @PathVariable Long id){
        Optional<Neighborhood> neighborhoodOptional = Optional.ofNullable(neighborhoodService.findById(id));
        if (neighborhoodOptional.isPresent()){
            Neighborhood neighborhood = neighborhoodOptional.get();

            //Probar utilizando la libreria Mapstruct
            NeighborhoodDTO neighborhoodDTO = NeighborhoodDTO.builder()
                    .id(neighborhood.getId())
                    .name(neighborhood.getName())
                    .build();
            return ResponseEntity.ok(neighborhoodDTO);
        }
        return ResponseEntity.notFound().build();
    }
}

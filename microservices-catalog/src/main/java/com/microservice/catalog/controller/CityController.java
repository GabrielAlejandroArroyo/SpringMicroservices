package com.microservice.catalog.controller;

import com.microservice.catalog.controller.dto.CityDTO;
import com.microservice.catalog.entities.City;
import com.microservice.catalog.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/catalog/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody City city){
        cityService.save(city);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
            List<CityDTO> cities= cityService.findAll()
                    .stream()
                    .map(city -> CityDTO.builder()
                            .id(city.getId())
                            .name(city.getName())
                            .neighborhoods(city.getNeighborhoods())
                            .build())
                    .toList();
            return ResponseEntity.ok(cities);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById( @PathVariable Long id){
        Optional<City> cityOptional = Optional.ofNullable(cityService.findById(id));
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();

            //Probar utilizando la libreria Mapstruct
            CityDTO cityDTO = CityDTO.builder()
                    .id(city.getId())
                    .name(city.getName())
                    .neighborhoods(city.getNeighborhoods())
                    .build();
            return ResponseEntity.ok(cityDTO);
        }
        return ResponseEntity.notFound().build();
    }
}

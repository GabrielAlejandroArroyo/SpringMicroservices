package com.microservice.catalog.controller;

import com.microservice.catalog.controller.dto.CountryDTO;
import com.microservice.catalog.entities.Country;
import com.microservice.catalog.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/catalog/country")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save (@RequestBody CountryDTO countryDTO) throws URISyntaxException {
        if (countryDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        countryService.save(Country.builder()
                .name(countryDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/catalog/country/create")).build();
    }

    @PostMapping("/update/{id}")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save (@PathVariable Long id ,@RequestBody CountryDTO countryDTO) {
        Optional<Country> countryOptional = Optional.ofNullable(countryService.findById(id));
        if(countryOptional.isPresent()){
            Country country = countryOptional.get();
            country.setName(countryDTO.getName());
            countryService.save(country);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Long id) {
        if (id !=null){
            countryService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<CountryDTO>  countries= countryService.findAll()
                .stream()
                .map(country -> CountryDTO.builder()
                        .id(country.getId())
                        .name(country.getName())
                        .states(country.getStates())
                        .build())
                .toList();

        return ResponseEntity.ok(countries);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById( @PathVariable Long id){
        Optional<Country> countryOptional = Optional.ofNullable(countryService.findById(id));
        if (countryOptional.isPresent()){
            Country country = countryOptional.get();

            //Probar utilizando la libreria Mapstruct
            CountryDTO countryDTO = CountryDTO.builder()
                    .id(country.getId())
                    .name(country.getName())
                    .states(country.getStates())
                    .build();
            return ResponseEntity.ok(countryDTO);
        }
        return ResponseEntity.notFound().build();
    }
}

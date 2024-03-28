package com.microservice.catalog.controller;

import com.microservice.catalog.controller.dto.StateDTO;
import com.microservice.catalog.entities.State;
import com.microservice.catalog.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog/state")
public class StateController {
    @Autowired
    private IStateService stateService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody State state){
        stateService.save(state);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
        List<StateDTO> states= stateService.findAll()
                .stream()
                .map(state -> StateDTO.builder()
                        .id(state.getId())
                        .name(state.getName())
                        .cities(state.getCities())
                        .build())
                .toList();
        return ResponseEntity.ok(states);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById( @PathVariable Long id){
        Optional<State> stateOptional = Optional.ofNullable(stateService.findById(id));
        if (stateOptional.isPresent()){
            State state = stateOptional.get();

            //Probar utilizando la libreria Mapstruct
            StateDTO stateDTO = StateDTO.builder()
                    .id(state.getId())
                    .name(state.getName())
                    .cities(state.getCities())
                    .build();
            return ResponseEntity.ok(stateDTO);
        }
        return ResponseEntity.notFound().build();
    }
}

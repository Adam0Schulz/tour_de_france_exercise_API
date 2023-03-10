package com.exercise.tourdefrance_exercise.controller;

import com.exercise.tourdefrance_exercise.model.Cyclist;
import com.exercise.tourdefrance_exercise.repo.CyclistRepo;
import com.exercise.tourdefrance_exercise.service.CyclistService;
import com.exercise.tourdefrance_exercise.service.Enums.Jersey;
import com.exercise.tourdefrance_exercise.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cyclists")
public class CyclistController extends GeneralController<Cyclist, CyclistRepo, CyclistService> {

    private final CyclistService service;


    @Autowired
    public CyclistController(CyclistService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(value = "", params = "teamId")
    public ResponseEntity<List<Cyclist>> getByTeamId(@RequestParam(name = "teamId") Long id) {
        List<Cyclist> cyclists = service.getAll().stream()
                                        .filter(cyclist -> Objects.equals(cyclist.getTeam().getId(), id))
                                        .toList();
        return new ResponseEntity<List<Cyclist>>(cyclists, HttpStatus.OK);
    }

    @GetMapping(value = "", params = "jersey")
    public ResponseEntity<Cyclist> getByJersey(@RequestParam(name = "jersey") Jersey jersey) {
        return new ResponseEntity<Cyclist>(service.getByJersey(jersey), HttpStatus.OK);
    }



}

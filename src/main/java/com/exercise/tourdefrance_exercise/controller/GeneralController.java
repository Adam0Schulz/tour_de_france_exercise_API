package com.exercise.tourdefrance_exercise.controller;

import com.exercise.tourdefrance_exercise.model.Model;
import com.exercise.tourdefrance_exercise.service.GeneralService;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GeneralController<T extends Model,R extends JpaRepository<T, Long>, S extends GeneralService<T, R>>{

    private final S service;

    public GeneralController(S service) {
        this.service = service;
    }





}

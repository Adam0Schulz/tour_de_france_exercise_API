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


    // Basic CRUD
    @GetMapping("")
    public ResponseEntity<List<T>> getAll() {
        return new ResponseEntity<List<T>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<T>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<T> create(@RequestBody T newObject) {
        return new ResponseEntity<T>(service.create(newObject), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable(name = "id") Long id, @RequestBody T updateObject) {
        return new ResponseEntity<T>(service.update(id, updateObject), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable(name = "id") Long id) {
        try {
            service.delete(id);
            return HttpStatus.NO_CONTENT;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    //Extra
    @GetMapping(value = "", params = {"field", "direction"})
    public ResponseEntity<List<T>> getSorted(@RequestParam(name = "field") String field, @RequestParam(name = "direction") Sort.Direction direction) {
        return new ResponseEntity<>(service.getSorted(field, direction), HttpStatus.OK);
    }


}

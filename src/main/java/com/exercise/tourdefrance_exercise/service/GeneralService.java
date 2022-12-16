package com.exercise.tourdefrance_exercise.service;


import com.exercise.tourdefrance_exercise.model.Model;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GeneralService<T extends Model, R extends JpaRepository<T, Long>>{

    private final R repo;

    public GeneralService(R repo) {
        this.repo = repo;
    }

    // Basic CRUD
    public List<T> getAll() {
        return repo.findAll();
    }

    public T getById(Long id) {
        return repo.findById(id)
                    .orElseThrow(IllegalArgumentException::new);
    }

    public T create(T object) {
        return repo.save(object);
    }

    public T update(Long id, T updateObject) {
        updateObject.setId(id);
        if (repo.findById(id).isPresent())
            return repo.save(updateObject);

        throw new IllegalArgumentException();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Extra
    public List<T> getSorted(String field, Sort.Direction direction) {
        return repo.findAll(Sort.by(direction, field));
    }
}

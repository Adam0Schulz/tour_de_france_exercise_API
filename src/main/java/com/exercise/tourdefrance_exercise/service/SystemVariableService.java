package com.exercise.tourdefrance_exercise.service;

import com.exercise.tourdefrance_exercise.model.SystemVariable;
import com.exercise.tourdefrance_exercise.repo.SystemVariableRepo;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemVariableService extends GeneralService<SystemVariable, SystemVariableRepo> {

    private final SystemVariableRepo repo;

    public SystemVariableService(SystemVariableRepo repo) {
        super(repo);
        this.repo = repo;
    }

    public SystemVariable getByName(String name) {
        return repo.getByName(name).orElseThrow(IllegalArgumentException::new);
    }
}

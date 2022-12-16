package com.exercise.tourdefrance_exercise.repo;

import com.exercise.tourdefrance_exercise.model.Cyclist;
import com.exercise.tourdefrance_exercise.model.SystemVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemVariableRepo extends JpaRepository<SystemVariable, Long> {

    public Optional<SystemVariable> getByName (String name);

}

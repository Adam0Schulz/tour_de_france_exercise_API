package com.exercise.tourdefrance_exercise.repo;


import com.exercise.tourdefrance_exercise.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepo extends JpaRepository<Cyclist, Long> {
}

package com.exercise.tourdefrance_exercise.repo;


import com.exercise.tourdefrance_exercise.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {
}

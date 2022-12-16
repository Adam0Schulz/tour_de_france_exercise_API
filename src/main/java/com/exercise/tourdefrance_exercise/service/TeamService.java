package com.exercise.tourdefrance_exercise.service;

import com.exercise.tourdefrance_exercise.model.Team;
import com.exercise.tourdefrance_exercise.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService extends GeneralService<Team, TeamRepo> {

    private final TeamRepo repo;

    @Autowired
    public TeamService(TeamRepo repo) {
        super(repo);
        this.repo = repo;
    }
}

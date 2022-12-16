package com.exercise.tourdefrance_exercise.controller;

import com.exercise.tourdefrance_exercise.model.Team;
import com.exercise.tourdefrance_exercise.repo.TeamRepo;
import com.exercise.tourdefrance_exercise.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController extends GeneralController<Team, TeamRepo, TeamService> {

    private final TeamService service;

    @Autowired
    public TeamController(TeamService service) {
        super(service);
        this.service = service;
    }
}

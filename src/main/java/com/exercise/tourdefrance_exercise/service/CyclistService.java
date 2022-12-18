package com.exercise.tourdefrance_exercise.service;

import com.exercise.tourdefrance_exercise.model.Cyclist;
import com.exercise.tourdefrance_exercise.repo.CyclistRepo;
import com.exercise.tourdefrance_exercise.service.Enums.Jersey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CyclistService extends GeneralService<Cyclist, CyclistRepo> {

    private final CyclistRepo repo;
    private final SystemVariableService systemVariableService;

    @Autowired
    public CyclistService(CyclistRepo repo, SystemVariableService systemVariableService) {
        super(repo);
        this.repo = repo;
        this.systemVariableService = systemVariableService;
    }

    public Cyclist getYellowJersey() {
        return getSorted("totalTime", Sort.Direction.ASC).get(0);
    }

    public Cyclist getDottedJersey() {
        return getSorted("mountainPoints", Sort.Direction.DESC).get(0);
    }

    public Cyclist getGreenJersey() {
        return getSorted("sprintPoints", Sort.Direction.DESC).get(0);
    }

    // There's a "magic number" for getting the system variable - that's a bad practise
    public Cyclist getWhiteJersey() {
        return getSorted("totalTime", Sort.Direction.ASC).stream()
                .filter((cyclist) -> cyclist.getAge() < Integer.parseInt(systemVariableService.getById(1L).getStringValue()))
                .toList()
                .get(0);
    }

    public Cyclist getByJersey(Jersey jersey) {
        return switch (jersey) {
            case YELLOW -> getYellowJersey();
            case DOTTED -> getDottedJersey();
            case GREEN -> getGreenJersey();
            case WHITE -> getWhiteJersey();
        };
    }
}

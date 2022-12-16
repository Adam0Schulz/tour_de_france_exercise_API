package com.exercise.tourdefrance_exercise.service;

import com.exercise.tourdefrance_exercise.model.Cyclist;
import com.exercise.tourdefrance_exercise.repo.CyclistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CyclistService extends GeneralService<Cyclist, CyclistRepo> {

    @Autowired
    public CyclistService(CyclistRepo repo) {
        super(repo);
    }
}

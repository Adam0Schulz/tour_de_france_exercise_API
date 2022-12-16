package com.exercise.tourdefrance_exercise.controller;

import com.exercise.tourdefrance_exercise.model.SystemVariable;
import com.exercise.tourdefrance_exercise.repo.SystemVariableRepo;
import com.exercise.tourdefrance_exercise.service.GeneralService;
import com.exercise.tourdefrance_exercise.service.SystemVariableService;

public class SystemVariableController extends GeneralController<SystemVariable, SystemVariableRepo, SystemVariableService>  {

    private final SystemVariableService service;

    public SystemVariableController(SystemVariableService service) {
        super(service);
        this.service = service;
    }
}

package com.exercise.tourdefrance_exercise.service;

import com.exercise.tourdefrance_exercise.model.Cyclist;
import com.exercise.tourdefrance_exercise.model.SystemVariable;
import com.exercise.tourdefrance_exercise.repo.CyclistRepo;
import com.exercise.tourdefrance_exercise.repo.SystemVariableRepo;
import com.exercise.tourdefrance_exercise.service.Enums.Jersey;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class CyclistServiceTest {

    @Autowired
    CyclistRepo repo;
    @Autowired
    SystemVariableRepo variableRepo;

    SystemVariableService variableService;
    CyclistService service;

    Cyclist cyclistOne;
    Cyclist cyclistTwo;
    Cyclist cyclistThree;
    Cyclist cyclistFour;

    @BeforeEach
    public void setup() {

        variableService = new SystemVariableService(variableRepo);
        service = new CyclistService(repo, variableService);


        // given
        SystemVariable variable = SystemVariable.builder()
                .name("junior age limit")
                .StringValue("26")
                .build();
        cyclistOne = Cyclist.builder()
                .age(25)
                .firstName("Adam")
                .lastName("Schulz")
                .sprintPoints(10)
                .mountainPoints(5)
                .totalTime(5F)
                .build();
        cyclistTwo = Cyclist.builder()
                .age(21)
                .firstName("Adam")
                .lastName("Schulz")
                .sprintPoints(5)
                .mountainPoints(10)
                .totalTime(5F)
                .build();
        cyclistThree = Cyclist.builder()
                .age(30)
                .firstName("Adam")
                .lastName("Schulz")
                .sprintPoints(5)
                .mountainPoints(5)
                .totalTime(4F)
                .build();
        cyclistFour = Cyclist.builder()
                .age(18)
                .firstName("adam")
                .lastName("schulz")
                .sprintPoints(5)
                .mountainPoints(5)
                .totalTime(4.5F)
                .build();

        //when
        service.create(cyclistOne);
        service.create(cyclistTwo);
        service.create(cyclistThree);
        variableService.create(variable);

    }

    @AfterEach
    public void tearDown() {
        repo.deleteAll();
    }

    @Test
    void getAllReturnsList() {

        //then
        assertThat(service.getAll()).hasSize(3);

    }

    @Test
    void getByJerseyReturnsDotted() {

        //then
        assertThat(service.getByJersey(Jersey.DOTTED).getId()).isEqualTo(cyclistTwo.getId());
    }

    @Test
    void getByJerseyReturnsYellow() {

        //then
        assertThat(service.getByJersey(Jersey.YELLOW).getId()).isEqualTo(cyclistThree.getId());
    }

    @Test
    void getByJerseyReturnsGreen() {

        //then
        assertThat(service.getByJersey(Jersey.GREEN).getId()).isEqualTo(cyclistOne.getId());
    }

    @Test
    @Disabled
    void getByJerseyReturnsWhite() {

        //then
        assertThat(service.getByJersey(Jersey.WHITE).getId()).isEqualTo(cyclistFour.getId());
    }

}
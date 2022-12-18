package com.exercise.tourdefrance_exercise.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "cyclists")
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Float totalTime;

    @Column
    private int sprintPoints;

    @Column
    private int mountainPoints;

    @Column
    private int age;

    @ManyToOne
    private Team team;

}

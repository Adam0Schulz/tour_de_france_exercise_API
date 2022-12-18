package com.exercise.tourdefrance_exercise.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "system_variables")
@NoArgsConstructor
@AllArgsConstructor
public class SystemVariable extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String StringValue;
}

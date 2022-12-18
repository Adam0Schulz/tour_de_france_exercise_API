package com.exercise.tourdefrance_exercise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
public class Team extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    public Set<Cyclist> cyclists;



}

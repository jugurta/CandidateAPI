package com.extia.services.api.candidate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @Column(name = "candidate_name")

    private String name;

    @Column(name = "candidate_surname")

    private String surname;

    @Column(name = "candidate_age")

    private long age;

    @Column(name = "candidate_interview_mark")

    private long interview_mark;

}

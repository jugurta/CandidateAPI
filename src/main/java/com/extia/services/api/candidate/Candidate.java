package com.extia.services.api.candidate;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(min = 5, max = 50)
    private String name;

    @Column(name = "candidate_surname")
    @Size(min = 5, max = 50)
    private String surname;

    @Column(name = "candidate_age")
    @Size(min = 5, max = 50)
    private long age;

    @Column(name = "candidate_interview_mark")
    @Size(min = 5, max = 50)
    private long interview_mark;

}

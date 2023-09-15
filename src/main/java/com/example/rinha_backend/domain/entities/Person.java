package com.example.rinha_backend.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.Range;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "theId")
    private String id;

    @Range(from = 3, to = 32)
    @Column(unique = true, name = "nick")
    private String nickname;

    @NonNull
    @Range(from = 3, to = 100)
    @Column(name = "theName")
    private String name;

    @NonNull
    @Column(name = "dateBirth")
    private Date birthDate;

    @ElementCollection
    @Column(name = "theStack")
    private List<String> stack;
}

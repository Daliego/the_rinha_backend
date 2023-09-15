package com.example.rinha_backend.domain.repository;

import com.example.rinha_backend.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findAllByNicknameAfterOrNameAfterOrStack(String nickname, String name, String Stack);
}

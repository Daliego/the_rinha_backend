package com.example.rinha_backend.presentation;

import com.example.rinha_backend.domain.dtos.CreatePersonDto;
import com.example.rinha_backend.domain.entities.Person;
import com.example.rinha_backend.domain.errors.AppErrorException;
import com.example.rinha_backend.domain.repository.PersonRepository;
import com.example.rinha_backend.domain.services.PersonUsecase;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonUsecase personUsecase;

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody CreatePersonDto personDto) {
        Person person = personUsecase.createPerson(personDto);

        return ResponseEntity.ok().body(person);
    }


    @GetMapping("/all-person")
    public ResponseEntity<HashMap<String, Object>> getAllPerson() {
        HashMap<String, Object> hashMap = personUsecase.getAllPerson();

        return ResponseEntity.ok().body(hashMap);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") String id) throws AppErrorException {
        Person person = personUsecase.getPersonById(id);

        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/person")
    public ResponseEntity<HashMap<String, Object>> getPersonByQuery(@RequestParam String text) throws AppErrorException {
        HashMap<String, Object> hashMap = personUsecase.getPersonBySearchText(text);

        return ResponseEntity.ok().body(hashMap);
    }


}

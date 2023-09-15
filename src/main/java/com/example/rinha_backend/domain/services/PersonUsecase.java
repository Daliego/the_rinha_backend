package com.example.rinha_backend.domain.services;

import com.example.rinha_backend.domain.dtos.CreatePersonDto;
import com.example.rinha_backend.domain.entities.Person;
import com.example.rinha_backend.domain.errors.AppErrorException;
import com.example.rinha_backend.domain.repository.PersonRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonUsecase {
    @NonNull
    private final PersonRepository personRepository;

    public Person createPerson(CreatePersonDto createPersonDto) {
        Person person = new Person();
        BeanUtils.copyProperties(createPersonDto, person);

        System.out.println("Isso é uma persona:");
        System.out.println(person.getName());
        person.setId(String.valueOf(UUID.randomUUID()));
        return personRepository.save(person);
    }

    public Person getPersonById(String nickname) throws AppErrorException {
        Optional<Person> person =  personRepository.findById(nickname);

        if (!person.isPresent()) {
            throw new AppErrorException("The nickname: %s was not founded".formatted(nickname), HttpStatus.resolve(404));
        }

        return person.get();
    }

    public HashMap<String, Object> getPersonBySearchText(String text) throws AppErrorException {
        HashMap<String, Object> hashMap = new HashMap<>();

        List<Person> personList = personRepository.findAllByNicknameAfterOrNameAfterOrStack(text, text, text);

        hashMap.put("peoples", personList);
        hashMap.put("length", personList.size());

        return hashMap;
    }

    public HashMap<String, Object> getAllPerson() {
        List<Person> personList = personRepository.findAll();

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("peoples", personList);
        hashMap.put("length", personList.size());

        return hashMap;
    }
}

package com.example.rinha_backend.domain.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class CreatePersonDto {
    private String nickname;
    private String name;
    private Date birthDate;
    private List<String> stack;
}

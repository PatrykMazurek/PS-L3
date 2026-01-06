package com.example.rest_example.service;


import com.example.rest_example.model.Person;
import com.example.rest_example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> getAllPerson(){
        return repository.findAll();
    }

}

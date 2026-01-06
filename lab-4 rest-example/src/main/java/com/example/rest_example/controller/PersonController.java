package com.example.rest_example.controller;

import com.example.rest_example.model.Person;
import com.example.rest_example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok().body(personService.getAllPerson());
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
//
//    }


}

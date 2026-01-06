package com.example.rest_example.repository;

import com.example.rest_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    List<Person> findByFirstNameAndCity(String firstName, String city);
}

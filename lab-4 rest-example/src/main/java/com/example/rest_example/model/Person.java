package com.example.rest_example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name", length = 140)
    private String firstName;
    @Column(length = 140)
    private String lastName;
    private int age;
    @Column(length = 50)
    private String city;

}

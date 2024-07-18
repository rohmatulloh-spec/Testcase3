package com.example.TestCase3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class KaryawanModel {
    
    @Id
    @GeneratedValue  (strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
   
    private String lastName;

    private String email;

    private Integer age;

    private Boolean isDeleted; 

}

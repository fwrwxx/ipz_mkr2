package com.example.projectmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ім'я користувача не може бути пустим.")
    private String name;

    @NotBlank(message = "Email не може бути пустим.")
    @Email(message = "Неправильний формат email.")
    private String email;

    @ManyToMany(mappedBy = "members")
    private List<Project> projects = new ArrayList<>();

    // Геттери і сеттери...
}

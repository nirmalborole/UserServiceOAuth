package com.example.userserviceoauth.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import javax.management.relation.Role;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @ElementCollection
    private List<Role> roles;

}

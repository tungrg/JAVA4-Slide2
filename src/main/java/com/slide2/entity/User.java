package com.slide2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    private String Id;
    private String Fullname;
    private String Email;
    private String Password;
    private boolean Admin;
}

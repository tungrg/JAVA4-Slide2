package com.slide2;

import javax.swing.text.html.parser.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.slide2.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class Slide2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Slide2Application.class, args);
	}

}

package com.slide2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.slide2.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class UserService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void saveUser(User user) {
        try {
            if(getUserById(user.getId()) != null) {
                entityManager.merge(user);
                entityManager.getTransaction().commit();
                System.out.println("User updated successfully!");
            } else {
                entityManager.persist(user);
                entityManager.getTransaction().commit();
                System.out.println("User created successfully!");
            }
        } catch (Exception e) {
            System.err.println("Error saving user: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
        System.out.println("User saved successfully!");
    }


    public void deleteUser(User user) {
        try {
            User existingUser = getUserById(user.getId());
            if (existingUser != null) {
                entityManager.remove(existingUser);
                entityManager.getTransaction().commit();
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found!");
            }
        } catch (Exception e) {
            System.err.println("Error deleting user: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    
    public User getUserById(String id) {
        return entityManager.find(User.class, id);
    }
}

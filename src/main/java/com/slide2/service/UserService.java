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
    
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        System.out.println("User saved successfully!");
    }
    @Transactional
    public void deleteUser(User user) {
        entityManager.remove(user);
        System.out.println("User deleted successfully!");
    }
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    @Transactional
    public User getUserById(String id) {
        return entityManager.find(User.class, id);
    }
}

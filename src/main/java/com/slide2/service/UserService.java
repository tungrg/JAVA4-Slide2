package com.slide2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slide2.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveUser(User user) {
        if (user.getId() != null && !user.getId().isEmpty() && getUserById(user.getId()) != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
    }

    @Transactional
    public void deleteUserById(String id) {
        User userToDelete = getUserById(id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User getUserById(String id) {
        return entityManager.find(User.class, id);
    }
}

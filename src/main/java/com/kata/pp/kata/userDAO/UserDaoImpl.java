package com.kata.pp.kata.userDAO;

import com.kata.pp.kata.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User ",User.class).getResultList();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Transactional
    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }
}

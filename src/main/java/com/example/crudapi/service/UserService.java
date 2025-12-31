package com.example.crudapi.service;

import com.example.crudapi.model.User;
import com.example.crudapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() { return repo.findAll(); }

    public User getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(User user) { return repo.save(user); }

    public User update(Long id, User updatedUser) {
        User user = getById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setAge(updatedUser.getAge());
        return repo.save(user);
    }

    public void delete(Long id) { repo.deleteById(id); }
}

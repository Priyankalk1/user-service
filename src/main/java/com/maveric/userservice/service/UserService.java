package com.maveric.userservice.service;

import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> saveUser(List<User> user)
    {
        return userRepository.saveAll(user);
    }

    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    public User getUserById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }


    public String deleteUser(int id)
    {
         userRepository.deleteById(id);
        return "user removed"+id;
    }

    public User userUpdate(User user)
    {
        User existingUser= userRepository.findById(user.getId()).orElse(null);

        existingUser.setFirstname(user.getFirstname());
        existingUser.setMiddlename(user.getMiddlename());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        existingUser.setDateOfBirth(user.getDateOfBirth());
        existingUser.setCreatedAt(user.getCreatedAt());
        existingUser.setUpdatedAt(user.getUpdatedAt());
        existingUser.setRole(user.getRole());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);

    }



}

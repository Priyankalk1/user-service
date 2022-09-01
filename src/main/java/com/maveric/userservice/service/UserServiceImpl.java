package com.maveric.userservice.service;

import com.maveric.userservice.exception.ResourceNotFoundException;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        user = new User(user.getId(),user.getFirstname(),user.getMiddlename(),user.getLastname(),
                user.getEmail(),user.getPhoneNumber(),user.getAddress(),user.getDateOfBirth(),
                user.getCreatedAt(),user.getUpdatedAt(),user.getRole(),user.getPassword());

        return userRepository.save(user);

    }

    @Override
    public List<User> getUserDetails(Integer id) {

        return (List<User>) userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Integer id, User user) {

        User updatedUser=  null;
        id = user.getId();
        User userToBeUpdated = userRepository.findById(id).orElse(null);
        if(userToBeUpdated != null) {
            updatedUser = userRepository.save(user);
        }

        return updatedUser;
    }

    @Override
    public String deleteUser(Integer id) {
        /*userRepository.deleteById(id);
        return id+" user deleted";*/
        User userToBeDeleted = userRepository.findById(id).orElse(null);
        if(userToBeDeleted != null) {
            userRepository.deleteById(id);
        }
        return id+" user deleted";
    }

    @Override
    public User getUserDetailsByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }

}

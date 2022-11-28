package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.UserAlreadyExistException;
import com.maveric.userservice.exception.UserNotFoundException;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.maveric.userservice.constants.Constants.USER_DELETED_SUCCESS;
import static com.maveric.userservice.constants.Constants.USER_NOT_FOUND_MESSAGE;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public List<UserDto> getUsers(Integer page, Integer pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        Page<User> pageResult = repository.findAll(paging);
        if (pageResult.hasContent()) {
            List<User> users = pageResult.getContent();
            log.info("Retrieved list of all users");
            return mapper.mapToDto(users);
        } else {
            log.error("No User info found!");
            return new ArrayList<>();
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        String pass = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(pass);
        User userResult = repository.findByEmail(userDto.getEmail());
        if (userResult == null) {
            User user = mapper.map(userDto);
            User userResult2 = repository.save(user);
            log.error("Created new user successfully");
            return mapper.map(userResult2);
        } else {
            log.error("User Already Exist for this emailId");
            throw new UserAlreadyExistException("User Already Exist! for this emailId");
        }
    }

    @Override
    public UserDto getUserDetails(String userId) {
        User userResult = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        log.info("Retrieved list of user details for given UserId");
        return mapper.map(userResult);
    }

    @Override
    public String deleteUser(String userId) {
        if (repository.findById(userId).isEmpty()) {
            log.info("UserId does not exist! Cannot delete User details.");
            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE + userId);
        }
        repository.deleteById(userId);
        log.info("Deleted user details for given UserId");
        return USER_DELETED_SUCCESS;
    }

    @Override
    public UserDto getUserDetailsByEmail(String emailId) {
        User userResult = repository.findByEmail(emailId);
        if (userResult != null)
        {
            log.info("Retrieved list of user details for given emailId");
            return mapper.map(userResult);
        }
        else
        {
            log.info("User details does not exist! Returns empty User details.");
            return new UserDto();
        }
    }
    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        if (userId.equals(userDto.get_id())) {
            User userResult = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
            userResult.set_id(userResult.get_id());
            userResult.setFirstName(userDto.getFirstName());
            userResult.setLastName(userDto.getLastName());
            userResult.setMiddleName(userDto.getMiddleName());
            userResult.setPhoneNumber(userDto.getPhoneNumber());
            userResult.setEmail(userDto.getEmail());
            userResult.setAddress(userDto.getAddress());
            userResult.setDateOfBirth(userDto.getDateOfBirth());
            userResult.setGender(userDto.getGender());
            User accountUpdated = repository.save(userResult);
            log.info("User details Updated Successfully for given UserId");
            return mapper.map(accountUpdated);
        } else {
            log.error("UserId does not exist! Cannot Update User details.");
            throw new UserNotFoundException("User Id not found! Cannot Update account.");
        }
    }
}

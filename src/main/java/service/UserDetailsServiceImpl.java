package service;

import dto.Userdto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository UserDetailsRepo;


    @Override
    public List<Userdto> getUser() {
        return null;
    }

    @Override
    public Userdto createUser(Userdto userDto) {
       // Userdto.setCreatedAt(getCurrentDateTime());

        //return UserDetailsRepo.save();

        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public String deleteUser(int id) {
        return null;
    }
}

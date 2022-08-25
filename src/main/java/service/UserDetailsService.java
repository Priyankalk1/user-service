package service;

import dto.Userdto;
import model.User;

import java.util.List;

public interface UserDetailsService<UserDetails> {

    public List<Userdto> getUser();

    public Userdto createUser(Userdto userDto);

    User getUserById(int id);
    public String deleteUser(int id);
}

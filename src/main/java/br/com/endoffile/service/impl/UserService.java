package br.com.endoffile.service.impl;

import br.com.endoffile.exception.UserNotFoundException;
import br.com.endoffile.model.User;

import java.util.List;

public interface UserService {

    User getUserById(long id) throws UserNotFoundException;

    List<User> getAllUsers();

    User updateUser(long id, User user) throws UserNotFoundException;

    User saveUser(User user);

    void deleteUser(long id) throws UserNotFoundException;
}

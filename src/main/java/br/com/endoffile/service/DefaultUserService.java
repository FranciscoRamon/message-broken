package br.com.endoffile.service;


import br.com.endoffile.exception.UserNotFoundException;
import br.com.endoffile.model.User;
import br.com.endoffile.repository.UserRepository;
import br.com.endoffile.service.impl.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Inject
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) throws UserNotFoundException {
        return this.userRepository.findByIdOptional(id).orElseThrow(
                () -> new UserNotFoundException("doesn't exist user")
        );
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.listAll();
    }

    @Transactional
    @Override
    public User updateUser(long id, User user) throws UserNotFoundException {
        User userForUpdate = this.userRepository.findById(id);
        userForUpdate.setAddress(user.getAddress());
        userForUpdate.setNome(user.getNome());
        userRepository.persist(userForUpdate);
        return userForUpdate;
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        this.userRepository.persistAndFlush(user);
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(long id) throws UserNotFoundException {
        this.userRepository.delete(getUserById(id));
    }
}

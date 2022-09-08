package sk.sb.training_assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Autowired means, that it is automatically connected to the created repository.
     * @param userRepository - repository, which is automatically initialized, when springboot application is started
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        //returning optional, because we don`t know whether user with given id exists
        return this.userRepository.findById(id);
    }

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}

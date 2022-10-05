package sk.sb.training_assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle transactions on User entity.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
@Service
public class UserService {

    /**
     * Repository for Address entity.
     */
    private final UserRepository userRepository;

    /**
     * Autowired means, that it is automatically connected to the created repository.
     * @param userRepository - repository, which is automatically initialized, when springboot application is started
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Finding all records in the User table.
     * @return List of all users sorted by their id in ascending order.
     */
    public List<User> findAllUsers() {
        return this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Finds user by given id.
     * @param id Unique identifier of the user.
     * @return User, if he exists in the database.
     */
    public Optional<User> findUserById(Long id) {
        //returning optional, because we don`t know whether user with given id exists
        return this.userRepository.findById(id);
    }

    /**
     * Adding a new user to a database.
     * @param user User to be added.
     * @return Added user.
     */
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * Update a user from a database.
     * @param user User to be updated.
     * @return Updated user.
     */
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * Deleting a user from a database.
     * @param id Unique identifier for the user to be deleted.
     */
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}

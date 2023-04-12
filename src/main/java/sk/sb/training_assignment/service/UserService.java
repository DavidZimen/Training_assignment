package sk.sb.training_assignment.service;

import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.service.Searchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.repository.UserRepository;
import sk.sb.training_assignment.search.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service to handle transactions on User entity.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
@Service
public class UserService implements Searchable<SearchResult> {

    /**
     * Repository for Address entity.
     */
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


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

    @Override
    public List<SearchResult> search(String query) {
        return userRepository.searchUsers(query)
                .stream()
                .map(user -> {
                    SearchResult result = userMapper.toSearchResultDto(user);
                    result.setResultType("User");
                    result.setResultLink("http://localhost:4201/user-info/" + result.getResultLocalId());
                    return result;
                })
                .collect(Collectors.toList());
    }
}

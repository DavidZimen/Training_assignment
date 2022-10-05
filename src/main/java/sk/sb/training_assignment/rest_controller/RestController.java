package sk.sb.training_assignment.rest_controller;

import org.springframework.web.bind.annotation.*;
import sk.sb.training_assignment.request.UserRequest;
import sk.sb.training_assignment.entities.Address;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.service.AddressService;
import sk.sb.training_assignment.service.UserService;
import java.util.List;
import java.util.Optional;

/**
 * RestController to handle Http requests from Angular client.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class RestController {
    /**
     * UserService to retrieve necessary ingormation about user.
     */
    private final UserService userService;
    /**
     * AddressService to retrieve necessary ingormation about user's address.
     */
    private final AddressService addressService;

    public RestController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    /**
     * @return All users in the database.
     */
    @GetMapping("all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * @param id Unique identifier to find the user.
     * @return Specific user with giver id.
     */
    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);
    }

    /**
     * @param userRequest Request to make user and his address.
     * @return User inserted in the database.
     */
    @PostMapping("add")
    public User addUser(@RequestBody UserRequest userRequest) {
        Address address = new Address(userRequest.getStreet(), userRequest.getHouseNumber(), userRequest.getCity());
        this.addressService.addAddress(address);
        User user = new User(userRequest.getName(), userRequest.getSurname(), userRequest.getBirthDate(), address);

        return this.userService.addUser(user);
    }

    /**
     * @param user User to be uptaded.
     * @return Instance of updated user.
     */
    @PutMapping("update")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    /**
     * Deletes user from database based on his id.
     * @param id Unique identifier of the user.
     */
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }
}

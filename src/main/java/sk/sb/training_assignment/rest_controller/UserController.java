package sk.sb.training_assignment.rest_controller;

import org.springframework.web.bind.annotation.*;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.service.UserService;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return this.userService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }
}

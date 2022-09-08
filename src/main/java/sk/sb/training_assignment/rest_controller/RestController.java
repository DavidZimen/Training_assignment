package sk.sb.training_assignment.rest_controller;

import org.springframework.web.bind.annotation.*;
import sk.sb.training_assignment.request.UserRequest;
import sk.sb.training_assignment.entities.Address;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.service.AddressService;
import sk.sb.training_assignment.service.UserService;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class RestController {

    private final UserService userService;
    private final AddressService addressService;

    public RestController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping("all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);
    }

    @PostMapping("add")
    public User addUser(@RequestBody UserRequest userRequest) {
        Address address = new Address();
        address.setCity(userRequest.getCity());
        address.setNumber(userRequest.getNumber());
        address.setStreet(userRequest.getStreet());

        this.addressService.addAddress(address);

        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setBirthDate(userRequest.getBirthDate());
        user.setAddress(address);

        return this.userService.addUser(user);
    }

    @PutMapping("update")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }
}

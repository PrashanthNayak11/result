package mykiddrawing.quiz.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import mykiddrawing.quiz.exception.ResourceNotFoundException;

import mykiddrawing.quiz.model.User;

import mykiddrawing.quiz.repository.UserRepository;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public List < User > getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity < User > getUserById(
        @PathVariable(value = "id") Long user_id) throws ResourceNotFoundException {
        User user = userRepository.findById(user_id)
            .orElseThrow(()-> new ResourceNotFoundException("User not found :: " + user_id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity < User > updateUser(
        @PathVariable(value = "id") Long user_id,
        @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(user_id)
            .orElseThrow(()-> new ResourceNotFoundException("User not found :: " + user_id));
        user.setUser_name(userDetails.getUser_name());
        user.setUser_mail(userDetails.getUser_mail());
        user.setUser_address(userDetails.getUser_address());
        user.setUser_gender(userDetails.getUser_gender());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Long user_id) throws ResourceNotFoundException {
        User user = userRepository.findById(user_id)
            .orElseThrow(()-> new ResourceNotFoundException("User not found :: " + user_id));

        userRepository.delete(user);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

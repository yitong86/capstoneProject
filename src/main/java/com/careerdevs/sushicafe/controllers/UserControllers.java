package com.careerdevs.sushicafe.controllers;

import com.careerdevs.sushicafe.models.User;
import com.careerdevs.sushicafe.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserControllers {
    @Autowired
    private UserRepositories userRepositories;
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        User user = userRepositories.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepositories.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable Long id){
        Optional<User> maybeUser = userRepositories.findById(id);
        if(maybeUser.isEmpty()){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(maybeUser.get(),HttpStatus.OK);
    }

}

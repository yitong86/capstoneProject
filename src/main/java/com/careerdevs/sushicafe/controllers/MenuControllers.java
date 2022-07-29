package com.careerdevs.sushicafe.controllers;


import com.careerdevs.sushicafe.models.MenuItems;
import com.careerdevs.sushicafe.models.User;
import com.careerdevs.sushicafe.repositories.MenuRepositories;
import com.careerdevs.sushicafe.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/menuitems")
public class MenuControllers {
    @Autowired
    private MenuRepositories menuRepositories;
    @PostMapping("/")
    public ResponseEntity<MenuItems> createUser(@RequestBody MenuItems newMenuItems){
        MenuItems menu = menuRepositories.save(newMenuItems);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<MenuItems>> getAllMenus(){
        List<MenuItems> menuItems = menuRepositories.findAll();
        return new ResponseEntity<>(menuItems,HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MenuItems>> getMenusByCategory(RestTemplate restTemplate, @PathVariable String category){
        List<MenuItems> menuItems = menuRepositories.findByCategory(category);
        return new ResponseEntity<>(menuItems,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenusById(RestTemplate restTemplate,@PathVariable long id){

        Optional<MenuItems> items = menuRepositories.findById(id);
            if (items.isEmpty()) {
                System.out.println(id + "did not match any item");

            }
            menuRepositories.deleteById(id);

            return ResponseEntity.ok(items);


    }



}

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

import java.awt.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/menuitems")
public class MenuControllers {
    @Autowired
    private MenuRepositories menuRepositories;
    @PostMapping("/")
    public ResponseEntity<MenuItems> createMenu(@RequestBody MenuItems newMenuItems){
        MenuItems menu = menuRepositories.save(newMenuItems);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }
    @PostMapping("/id/{id}")
    public ResponseEntity<MenuItems> update(@RequestBody MenuItems update,@PathVariable long id){

        MenuItems saveMenu = menuRepositories.save(update);
        return new ResponseEntity<>(saveMenu,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItems> updateMenu(@RequestBody MenuItems updateMenu,@PathVariable long id){

            MenuItems saveMenu = menuRepositories.save(updateMenu);
            return new ResponseEntity<>(saveMenu,HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<MenuItems>> getAllMenus(){
        List<MenuItems> menuItems = menuRepositories.findAll();
        return new ResponseEntity<>(menuItems,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenuItems> getMenuById(@PathVariable long id){
        Optional<MenuItems> menu = menuRepositories.findById(id);
        if(menu.isEmpty()){
            return new ResponseEntity<MenuItems>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(menu.get(),HttpStatus.OK);
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

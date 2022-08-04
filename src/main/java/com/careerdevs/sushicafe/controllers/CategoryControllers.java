package com.careerdevs.sushicafe.controllers;


import com.careerdevs.sushicafe.models.Category;
import com.careerdevs.sushicafe.models.MenuItems;
import com.careerdevs.sushicafe.repositories.CategoryRepositories;
import com.careerdevs.sushicafe.repositories.MenuRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
public class CategoryControllers {
    @Autowired
    private CategoryRepositories categoryRepositories;
    @PostMapping("/")
    public ResponseEntity<Category> createUser(@RequestBody Category newCategory){
        Category category= categoryRepositories.save(newCategory);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllMenus(){
        List<Category> category = categoryRepositories.findAll();
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}

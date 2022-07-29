package com.careerdevs.sushicafe.controllers;

import com.careerdevs.sushicafe.models.MenuItems;
import com.careerdevs.sushicafe.models.Review;
import com.careerdevs.sushicafe.repositories.MenuRepositories;
import com.careerdevs.sushicafe.repositories.ReviewRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/reviews")
public class ReviewControllers {

        @Autowired
        private ReviewRepositories reviewRepositories;
        @PostMapping("/")
        public ResponseEntity<Review> createReview(@RequestBody Review newReview){
            Review review = reviewRepositories.save(newReview);
            return new ResponseEntity<>(review, HttpStatus.CREATED);
        }

        @GetMapping("/")
        public ResponseEntity<List<Review>> getAllReviews(){
            List<Review> review= reviewRepositories.findAll();
            return new ResponseEntity<>(review,HttpStatus.OK);
        }

        @GetMapping("/score/{score}")
        public ResponseEntity<List<Review>> getReviewsByScore(RestTemplate restTemplate, @PathVariable String score){
            List<Review> review = reviewRepositories.findByScore(score);
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteReviewsById(RestTemplate restTemplate,@PathVariable long id){

            Optional<Review> reviews = reviewRepositories.findById(id);
            if (reviews.isEmpty()) {
                System.out.println(id + "did not match any item");

            }
            reviewRepositories.deleteById(id);

            return ResponseEntity.ok(reviews);


        }



    }

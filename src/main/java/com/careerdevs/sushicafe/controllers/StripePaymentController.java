package com.careerdevs.sushicafe.controllers;


import com.careerdevs.sushicafe.models.CreatePayment;
import com.careerdevs.sushicafe.models.CreatePaymentResponse;
import com.careerdevs.sushicafe.models.OrderByUser;
import com.careerdevs.sushicafe.models.User;
import com.careerdevs.sushicafe.repositories.PaymentRepositories;
import com.careerdevs.sushicafe.repositories.UserRepositories;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/checkout")
public class StripePaymentController {
    @Autowired
    private PaymentRepositories paymentRepositories;
    @PostMapping("/")
    public ResponseEntity<OrderByUser> createOrder(@RequestBody OrderByUser newOrder){

        OrderByUser orderByUser= paymentRepositories.save(newOrder);
        return new ResponseEntity<>(orderByUser, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<OrderByUser>> getAllOrders(){
        List<OrderByUser> orderByUsers = paymentRepositories.findAll();
        return new ResponseEntity<>(orderByUsers,HttpStatus.OK);
    }


}

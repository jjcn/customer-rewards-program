package com.joeyjin.rewards_program.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RewardsRestController {

    @GetMapping(value = "/")
    public ResponseEntity<String> getHomepage()  {
        String homepageMsg = "This is the Customer Rewards program API root.";
        return new ResponseEntity<>(homepageMsg, HttpStatus.OK);
    }
}

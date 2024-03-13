package com.priyanshu.resturantListing.controller;

import com.priyanshu.resturantListing.dto.RestaurantDTO;
import com.priyanshu.resturantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> restaurantDTOList = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);
    }
}

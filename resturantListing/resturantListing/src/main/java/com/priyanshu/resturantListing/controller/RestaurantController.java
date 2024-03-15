package com.priyanshu.resturantListing.controller;

import com.priyanshu.resturantListing.dto.RestaurantDTO;
import com.priyanshu.resturantListing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantAddedDTO = restaurantService.addRestaurant(restaurantDTO);
        return new ResponseEntity<>(restaurantAddedDTO,HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id){
        ResponseEntity<RestaurantDTO> fetchedRestaurantDTO = restaurantService.findRestaurantById(id);
        return fetchedRestaurantDTO;
    }
}

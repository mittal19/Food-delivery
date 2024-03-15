package com.priyanshu.resturantListing.service;

import com.priyanshu.resturantListing.dto.RestaurantDTO;
import com.priyanshu.resturantListing.entity.Restaurant;
import com.priyanshu.resturantListing.mapper.RestaurantMapper;
import com.priyanshu.resturantListing.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants(){
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(restaurant ->
            RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)
        ).collect(Collectors.toList());
        return restaurantDTOList;
    }

    public RestaurantDTO addRestaurant(RestaurantDTO newRestaurantDTO){
        Restaurant newRestaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(newRestaurantDTO);
        newRestaurant = restaurantRepo.save(newRestaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(newRestaurant);
    }

    public ResponseEntity<RestaurantDTO> findRestaurantById(Integer id){
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}

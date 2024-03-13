package com.priyanshu.resturantListing.service;

import com.priyanshu.resturantListing.dto.RestaurantDTO;
import com.priyanshu.resturantListing.entity.Restaurant;
import com.priyanshu.resturantListing.mapper.RestaurantMapper;
import com.priyanshu.resturantListing.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

package com.patel.controller;

import com.patel.model.Food;
import com.patel.model.Restaurant;
import com.patel.model.User;
import com.patel.request.CreateFoodRequest;
import com.patel.service.FoodService;
import com.patel.service.RestaurantService;
import com.patel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String keyword,
                                           @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);
        List<Food> food = foodService.searchFood(keyword);

        return new  ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean veg,
                                                 @RequestParam boolean seasonal,
                                                 @RequestParam boolean nonveg,
                                                 @PathVariable Long id,
                                                 @RequestParam(required = false) String foodCategory,
                                                 @RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwtToken(jwt);
        List<Food> food = foodService.getRestaurantsFood(id,veg,nonveg,seasonal,foodCategory);

        return new  ResponseEntity<>(food, HttpStatus.CREATED);
    }
}

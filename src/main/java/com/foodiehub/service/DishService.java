package com.foodiehub.service;

import com.foodiehub.entity.Dish;
import com.foodiehub.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        return dishRepository.findByRestaurantIdAndIsAvailableTrue(restaurantId);
    }

    public List<Dish> searchDishes(String name) {
        return dishRepository.findByNameContainingIgnoreCase(name);
    }

    public Dish getDishById(Long id) {
        return dishRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Dish not found"));
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long id, Dish dish) {
        Dish existingDish = getDishById(id);
        
        existingDish.setName(dish.getName());
        existingDish.setDescription(dish.getDescription());
        existingDish.setPrice(dish.getPrice());
        existingDish.setImageUrl(dish.getImageUrl());
        existingDish.setAvailable(dish.isAvailable());
        
        return dishRepository.save(existingDish);
    }

    public void deleteDish(Long id) {
        Dish dish = getDishById(id);
        dish.setAvailable(false);
        dishRepository.save(dish);
    }
} 
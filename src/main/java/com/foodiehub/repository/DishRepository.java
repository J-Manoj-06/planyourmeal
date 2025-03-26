package com.foodiehub.repository;

import com.foodiehub.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByRestaurantId(Long restaurantId);
    List<Dish> findByRestaurantIdAndIsAvailableTrue(Long restaurantId);
    List<Dish> findByNameContainingIgnoreCase(String name);
} 
package com.foodiehub.repository;

import com.foodiehub.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByLocationContainingIgnoreCase(String location);
    
    @Query("SELECT r FROM Restaurant r WHERE r.rating >= 4.0 ORDER BY r.rating DESC")
    List<Restaurant> findTopRatedRestaurants();
    
    List<Restaurant> findByCuisineContainingIgnoreCase(String cuisine);
    
    @Query("SELECT r FROM Restaurant r WHERE r.isActive = true ORDER BY r.rating DESC")
    List<Restaurant> findAllActiveRestaurants();
} 
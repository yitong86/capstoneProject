package com.careerdevs.sushicafe.repositories;

import com.careerdevs.sushicafe.models.MenuItems;
import com.careerdevs.sushicafe.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepositories extends JpaRepository<Review,Long> {
    List<Review> findByScore(String score);
}

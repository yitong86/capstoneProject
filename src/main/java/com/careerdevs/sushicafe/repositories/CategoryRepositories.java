package com.careerdevs.sushicafe.repositories;

import com.careerdevs.sushicafe.models.Category;
import com.careerdevs.sushicafe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category,Long> {
}

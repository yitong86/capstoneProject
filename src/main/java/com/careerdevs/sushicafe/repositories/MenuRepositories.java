package com.careerdevs.sushicafe.repositories;

import com.careerdevs.sushicafe.models.MenuItems;
import com.careerdevs.sushicafe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface MenuRepositories extends JpaRepository<MenuItems,Long> {
    List<MenuItems> findByCategory(String category);
}

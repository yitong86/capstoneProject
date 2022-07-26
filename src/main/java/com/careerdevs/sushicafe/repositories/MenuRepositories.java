package com.careerdevs.sushicafe.repositories;

import com.careerdevs.sushicafe.models.MenuItems;
import com.careerdevs.sushicafe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface MenuRepositories extends JpaRepository<MenuItems,Long> {
}

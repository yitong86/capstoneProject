package com.careerdevs.sushicafe.repositories;

import com.careerdevs.sushicafe.models.OrderByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositories extends JpaRepository<OrderByUser,Long> {

}

package com.wiproo.Mobile.repository;

import com.wiproo.Mobile.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<MobileEntity, Integer> {
    // can add custom queries if needed (e.g., findByModelNumber)
    boolean existsByModelNumber(String modelNumber);
}

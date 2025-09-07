package com.wiproo.order_ms.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiproo.order_ms.entity.*;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
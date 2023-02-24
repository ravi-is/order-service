package com.orderservice.repository;

import com.orderservice.entity.OrderInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInformationRepository extends JpaRepository<OrderInformation,Integer> {
}

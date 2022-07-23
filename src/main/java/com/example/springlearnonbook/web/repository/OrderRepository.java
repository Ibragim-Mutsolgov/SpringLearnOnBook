package com.example.springlearnonbook.web.repository;

import com.example.springlearnonbook.domain.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
}
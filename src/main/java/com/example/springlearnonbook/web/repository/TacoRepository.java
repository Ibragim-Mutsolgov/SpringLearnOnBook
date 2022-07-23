package com.example.springlearnonbook.web.repository;

import com.example.springlearnonbook.domain.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
}

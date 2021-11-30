package com.demo.repository;

import com.demo.entity.HomePage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePageRepository extends JpaRepository<HomePage,Integer> {
}

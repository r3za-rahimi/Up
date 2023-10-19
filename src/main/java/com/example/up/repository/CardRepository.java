package com.example.up.repository;

import com.example.up.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card , Long> {
}

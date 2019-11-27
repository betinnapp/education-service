package com.betinnapp.educationservice.repository;

import com.betinnapp.educationservice.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoinRepository extends JpaRepository<Coin, UUID> {

    Coin findByUserId(UUID userId);
}

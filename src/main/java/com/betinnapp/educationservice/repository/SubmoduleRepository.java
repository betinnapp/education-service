package com.betinnapp.educationservice.repository;

import com.betinnapp.educationservice.model.Submodule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubmoduleRepository extends JpaRepository<Submodule, UUID> {
}

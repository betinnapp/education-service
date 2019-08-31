package com.betinnapp.educationservice.repository;

import com.betinnapp.educationservice.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<Module, UUID> {
}

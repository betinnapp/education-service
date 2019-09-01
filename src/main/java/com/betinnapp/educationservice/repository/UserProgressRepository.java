package com.betinnapp.educationservice.repository;

import com.betinnapp.educationservice.model.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, UUID> {

    List<UserProgress> findByUserId(UUID userId);

    UserProgress findByModuleIDAndUserId(UUID moduleID, UUID userID);
}

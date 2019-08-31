package com.betinnapp.educationservice.model;

import com.betinnapp.educationservice.model.type.ModuleType;
import com.betinnapp.educationservice.model.type.StatusType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_module_progress")
public class UserProgress {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;

    @Column
    private UUID userId;

    @Column
    private UUID moduleID;

    @Enumerated
    @Column
    private ModuleType moduleType;

    @Enumerated
    @Column
    private StatusType statusType;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getModuleID() {
        return moduleID;
    }

    public void setModuleID(UUID moduleID) {
        this.moduleID = moduleID;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

package com.betinnapp.educationservice.model;

import com.betinnapp.educationservice.model.type.StatusType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "submodule")
public class Submodule {

    public Submodule() {
        this.status = StatusType.LOCKED;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String content;

    @Column
    private String image;

    @Column
    private UUID quizId;

    @Column
    private int submoduleOrder;

    @Column
    private int reward;

    @Transient
    private StatusType status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UUID getQuizId() {
        return quizId;
    }

    public void setQuizId(UUID quizId) {
        this.quizId = quizId;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public int getSubmoduleOrder() {
        return submoduleOrder;
    }

    public void setSubmoduleOrder(int submoduleOrder) {
        this.submoduleOrder = submoduleOrder;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}

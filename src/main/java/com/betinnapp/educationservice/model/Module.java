package com.betinnapp.educationservice.model;

import com.betinnapp.educationservice.model.type.StatusType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "module")
public class Module {

    public Module() {
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
    private String descrition;

    @Column
    private String image;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Collection<Submodule> submodule;

    @Column
    private int moduleOrder;

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

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Collection<Submodule> getSubmodule() {
        return submodule;
    }

    public void setSubmodule(Collection<Submodule> submodule) {
        this.submodule = submodule;
    }

    public int getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(int moduleOrder) {
        this.moduleOrder = moduleOrder;
    }
}

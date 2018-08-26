package ru.zakharov.enterprise.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name = null;

    private String shortDescription = null;

    private Date creationDate = null;

    public String getId() {
        return id;
    }

    @PrePersist
    private void prePersist() {
        creationDate = new Date();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}

package ru.zakharov.enterprise.dto;

import ru.zakharov.enterprise.entity.Category;

import java.util.Date;

public class CategoryDTO {

    private String id;

    private String name;

    private String shortDescription;

    private Date creationDate;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        if (category == null) return;
        this.id = category.getId();
        this.name = category.getName();
        this.shortDescription = category.getShortDescription();
        this.creationDate = category.getCreationDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

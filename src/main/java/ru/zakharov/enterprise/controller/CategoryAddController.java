package ru.zakharov.enterprise.controller;


import ru.zakharov.enterprise.dao.CategoryDAO;
import ru.zakharov.enterprise.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;

@ViewScoped
@ManagedBean
public class CategoryAddController {

    @Inject
    private CategoryDAO categoryDAO;

    public void saveCategory() {
        Category category = new Category();
        category.setName(name);
        category.setCreationDate(new Date());
        category.setShortDescription(shortDescription);
        categoryDAO.merge(category);
    }

    private String name = null;

    private String shortDescription = null;

    private Date creationDate = null;

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

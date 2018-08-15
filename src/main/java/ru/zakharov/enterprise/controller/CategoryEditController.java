package ru.zakharov.enterprise.controller;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.zakharov.enterprise.dao.CategoryDAO;
import ru.zakharov.enterprise.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class CategoryEditController {

    @Inject
    private CategoryDAO categoryDAO;

    @Nullable
    private String id;

    @NotNull
    private Category category = new Category();

    public void init() {
        final Category category = categoryDAO.getCategoryById(id);
        if (category != null) this.category = category;
    }

    public String save() {
        categoryDAO.merge(category);
        return "category-add";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

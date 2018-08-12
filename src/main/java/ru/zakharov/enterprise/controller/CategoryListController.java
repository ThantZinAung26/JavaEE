package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.dao.CategoryDAO;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class CategoryListController {

    @Inject
    private CategoryDAO categoryDAO;

    public List<String> getCategoriesNames() {
        return categoryDAO.getCategoriesNames();
    }

    public List<String> getCategoriesIds() {
        return categoryDAO.getCategoriesIds();
    }
}

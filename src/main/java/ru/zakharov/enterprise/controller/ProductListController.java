package ru.zakharov.enterprise.controller;

import javax.validation.constraints.NotNull;

import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import java.util.Collection;

@ViewScoped
@ManagedBean
public class ProductListController {

    @Inject
    private ProductDAO productDAO;

    @NotNull
    public Collection<Product> getListProducts() {
        return productDAO.getProducts();
    }

    public void removeProductById(String productId) {
        productDAO.removeProductById(productId);
    }
}

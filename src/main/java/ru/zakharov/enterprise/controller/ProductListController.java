package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class ProductListController {

    @Inject
    ProductDAO productDAO;



    public List<Product> getProducts() {
        return productDAO.getAllProducts();
    }

    public void removeProductById(String productId) {
        productDAO.removeProductById(productId);
    }
}

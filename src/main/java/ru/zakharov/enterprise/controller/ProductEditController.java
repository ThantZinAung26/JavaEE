package ru.zakharov.enterprise.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class ProductEditController {

    @Inject
    private ProductDAO productDAO;

    @Nullable
    private String id;

    @NotNull
    private Product product = new Product();

    public void init() {
        final Product product = productDAO.getProductById(id);
        if (product != null) this.product = product;
    }

    public String save() {
        productDAO.merge(product);
        return "product-list";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

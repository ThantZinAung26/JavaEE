package ru.zakharov.enterprise.dao;


import ru.zakharov.enterprise.entity.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@SessionScoped
public class CartDAO implements Serializable {

    @Inject
    private ProductDAO productDAO;

    private Map<String,Product> cart = new LinkedHashMap<>();

    public CartDAO() {
    }

    public void addProduct(String productId) {
        if (productId != null || !productId.equals("") )
            cart.put(productId, productDAO.getProductById(productId));
    }

    public Collection<Product> getProductsInCart() {
        return cart.values();
    }
}

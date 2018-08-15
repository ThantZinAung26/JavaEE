package ru.zakharov.enterprise.dao;


import ru.zakharov.enterprise.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductDAO extends AbstractDAO {

    public Product merge(Product product) {
        return entityManager.merge(product);
    }

    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("SELECT p FROM Product p");
        List<Product> allProducts = query.getResultList();
        return allProducts;
    }

    public void removeProductById(String productId) {
        Product product = entityManager.find(Product.class, productId);
        entityManager.remove(product);
    }

    public Product getProductById(String productId) {
        Product product = entityManager.find(Product.class, productId);
        return product;
    }
}

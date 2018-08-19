package ru.zakharov.enterprise.dao;


import ru.zakharov.enterprise.entity.Category;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.logger.Logger;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.Query;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
public class ProductDAO extends AbstractDAO {

    @Interceptors(Logger.class)
    public Product merge(Product product) {
        return entityManager.merge(product);
    }

    public List<Product> getAllProducts() {
        Query query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> allProducts = query.getResultList();
        return allProducts;
    }

    @Interceptors(Logger.class)
    public void removeProductById(String productId) {
        Product product = entityManager.find(Product.class, productId);
        entityManager.remove(product);
    }

    public Product getProductById(String productId) {
        Product product = entityManager.find(Product.class, productId);
        return product;
    }

    public List<Product> getProductByName(String productName) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.name = :productName",
                Product.class);
        query.setParameter("productName", productName);
        List<Product> productList= query.getResultList();
        return productList;
    }

    public List<Product> getListProductByCategoryId(String categoryId) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.category.id =:categoryId",
                Product.class);
        query.setParameter("categoryId", categoryId);
        List<Product> productList= query.getResultList();
        return productList;
    }

    public void setCategoryForProduct(String productId, String categoryId) {
        Product product = entityManager.find(Product.class, productId);
        Category category = entityManager.find(Category.class, categoryId);
        product.setCategory(category);
        entityManager.merge(product);
    }

    public void createProduct() {
        entityManager.persist(new Product());
    }
}

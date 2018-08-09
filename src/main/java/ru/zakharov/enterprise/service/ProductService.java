package ru.zakharov.enterprise.service;

import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ManagedBean(name = "productService")
@ApplicationScoped
public class ProductService {

    @Inject
    private ProductDAO productDAO;

    public Product createProduct() {
        Product newProduct = new Product("Имя продукта",
                "Краткое описание",
                "Полное описание",
                1000,
                "pictureFileName.jpg");
        productDAO.addProduct(newProduct);
        return newProduct;
    }

    public Collection<Product> getProducts() {
        return productDAO.getProducts();
    }

    public void mergeProduct(String productId, Product product) {
        productDAO.mergeProduct(productId, product);
    }

    public List<String> getProductsIDs() {
        List<String> productsIds = new ArrayList<String>();
        for (Product product : productDAO.getProducts()) {
            productsIds.add(product.getId());
        }
        return productsIds;
    }

    public List<String> getProductsNames() {
        List<String> productsNames = new ArrayList<>();
        for (Product product : productDAO.getProducts()) {
            productsNames.add(product.getName());
        }
        return productsNames;
    }

    public List<String> getProductsShortDesc() {
        List<String> productsShortDesc = new ArrayList<>();
        for (Product product : productDAO.getProducts()) {
            productsShortDesc.add(product.getShortDescription());
        }
        return productsShortDesc;
    }

    public List<Integer> getProductsPrice() {
        List<Integer> productsPrice = new ArrayList<>();
        for (Product product : productDAO.getProducts()) {
            productsPrice.add(product.getPrice());
        }
        return productsPrice;
    }


    public void addProduct(Product product2Add) {
        productDAO.addProduct(product2Add);
    }

    public void removeProduct(Product product) {
        productDAO.removeProductById(product.getId());
    }
}

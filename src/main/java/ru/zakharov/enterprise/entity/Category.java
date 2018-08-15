package ru.zakharov.enterprise.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category extends AbstractEntity {


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Product> productsInCategory;

    public Category() {}

    public Category(String name, String description) {
        setName(name);
        setShortDescription(description);
    }

    public void addToCategory(Product newProduct) {
        productsInCategory.add(newProduct);
    }

    public List<Product> getProductsInCategory() {
        return productsInCategory;
    }

    public void setProductsInCategory(List<Product> productsInCategory) {
        this.productsInCategory = productsInCategory;
    }
}

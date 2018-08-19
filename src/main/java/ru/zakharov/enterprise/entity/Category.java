package ru.zakharov.enterprise.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedEntityGraph(name = "graph.Category.products",
        attributeNodes = @NamedAttributeNode(value = "productsInCategory"))
public class Category extends AbstractEntity {


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productsInCategory = new ArrayList<>();

    public Category() {
    }

    public Category(String name, String description) {
        setName(name);
        setShortDescription(description);
    }

    public Category(String name) {
        setName(name);
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

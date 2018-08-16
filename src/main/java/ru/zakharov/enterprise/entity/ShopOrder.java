package ru.zakharov.enterprise.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedEntityGraph(name = "graph.ShopOrder.products",
        attributeNodes = @NamedAttributeNode(value = "productsInOrder"))
public class ShopOrder extends AbstractEntity {

    private String fio = null;

    private String address = null;

    public ShopOrder() {

    }

    @ManyToMany
    private List<Product> productsInOrder;


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public void setProductsInOrder(List<Product> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }
}

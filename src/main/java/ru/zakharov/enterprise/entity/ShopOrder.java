package ru.zakharov.enterprise.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedEntityGraph(name = "graph.ShopOrder.products",
        attributeNodes = @NamedAttributeNode(value = "items"))
public class ShopOrder extends AbstractEntity {

    private String fio = null;

    private String address = null;

    public ShopOrder() {
    }

    @OneToMany(mappedBy = "shopOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}

package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.dao.ShopOrderDAO;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.entity.ShopOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.inject.Inject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
@ManagedBean
public class ShopOrderAddController {

    @Inject
    private ShopOrderDAO shopOrderDAO;

    @Inject
    private ProductDAO productDAO;

    private ShopOrder shopOrder= new ShopOrder();
    private List<Product> list = new LinkedList<>();

    private String name = null;

    private String fio = null;

    private String address = null;

    private String shortDescription = null;

    private Date creationDate = null;

    public void saveShopOrder() {
        shopOrder.setProductsInOrder(list);
        shopOrder.setName(name);
        shopOrder.setFio(fio);
        shopOrder.setAddress(address);
        shopOrder.setCreationDate(new Date());
        shopOrderDAO.merge(shopOrder);
    }


    public void addProductToOrder(Product product) {
        list.add(product);
    }


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

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

}

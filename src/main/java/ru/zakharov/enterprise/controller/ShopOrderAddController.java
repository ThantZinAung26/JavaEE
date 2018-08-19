package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.dao.ShopOrderDAO;
import ru.zakharov.enterprise.entity.OrderItem;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.entity.ShopOrder;
import ru.zakharov.enterprise.logger.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpSession;
import java.util.*;

@SessionScoped
@ManagedBean
public class ShopOrderAddController {

    @Inject
    private ShopOrderDAO shopOrderDAO;

    @Inject
    private ProductDAO productDAO;

    private HttpSession currentSession;


    private ShopOrder shopOrder = new ShopOrder();

    private List<OrderItem> list = new ArrayList<>();

    private String name = null;

    private String fio = null;

    private String address = null;

    private String shortDescription = null;

    private Date creationDate = null;

    @Interceptors(Logger.class)
    public void init(HttpSession session) {
        currentSession = session;
        currentSession.setAttribute(FieldConsts.ORDER_ID, shopOrder.getId());
        shopOrder.setItems(list);
        shopOrder.setName(name);
        shopOrder.setFio(fio);
        shopOrder.setAddress(address);
        shopOrder.setCreationDate(new Date());
    }

    @Interceptors(Logger.class)
    public void addProductToOrder(Product product) {

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(1);

        if (list.contains(orderItem)) {
            int index = list.indexOf(orderItem);
            int quantity = list.get(index).getQuantity();
            list.get(index).setQuantity(++quantity);
        } else {
            list.add(orderItem);
        }
        shopOrderDAO.merge(orderItem);

        shopOrder.setItems(list);
        shopOrderDAO.merge(shopOrder);
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

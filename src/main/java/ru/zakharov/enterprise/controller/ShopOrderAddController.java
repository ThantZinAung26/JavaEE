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
        if (shopOrderDAO.getOrderById(shopOrder.getId()) == null)
            shopOrderDAO.merge(shopOrder);
    }

    @Interceptors(Logger.class)
    public void addProductToOrder(Product product) {
        ShopOrder shopOrder = shopOrderDAO.getOrderById(this.shopOrder.getId());
        final List<OrderItem> orderItems = shopOrderDAO.getItem(this.shopOrder.getId(), product.getId());
        if (orderItems.size() == 0) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setShopOrder(this.shopOrder);
            newOrderItem.setProduct(product);
            newOrderItem.setQuantity(1);
            shopOrder.getItems().add(newOrderItem);
        } else {
            OrderItem oldOrderItem = orderItems.get(0);
            List<OrderItem> orderItemList = shopOrder.getItems();
            int quantity = 0;
            int index = 0;
            for (OrderItem item : orderItemList) {
                if (item.getId().equals(oldOrderItem.getId())) {
                    quantity = item.getQuantity();
                    index = orderItemList.indexOf(item);
                }
            }
            quantity++;
            shopOrder.getItems().get(index).setQuantity(quantity);
        }
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

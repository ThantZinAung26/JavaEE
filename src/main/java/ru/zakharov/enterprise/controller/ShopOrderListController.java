package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.dao.ShopOrderDAO;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.entity.ShopOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class ShopOrderListController {

    @Inject
    private ShopOrderDAO shopOrderDAO;


    public List<ShopOrder> getAllOrders() {
        return shopOrderDAO.getAllOrders();
    }

    public void removeOrderById(String orderId) {
        shopOrderDAO.removeOrderById(orderId);
    }

    public List<Product> getProductsInOrder(String orderId) {
        return shopOrderDAO.getProductsInOrderById(orderId);
    }

}

package ru.zakharov.enterprise.controller;

import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.CategoryDAO;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.dao.ShopOrderDAO;
import ru.zakharov.enterprise.entity.Product;
import ru.zakharov.enterprise.logger.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CartListController {

    @Inject
    private ShopOrderDAO shopOrderDAO;

    @Inject
    private ProductDAO productDAO;

    @Inject
    private CategoryDAO categoryDAO;

    private HttpSession currentSession = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);

    private String orderId;

    private List<Product> productList = new LinkedList<>();

    @Interceptors(Logger.class)
    public List<Product> getProductList() {
        orderId = (String) currentSession.getAttribute(FieldConsts.ORDER_ID);
        productList = shopOrderDAO.getOrderById(orderId).getProductsInOrder();
        return productList;
    }

    @Interceptors(Logger.class)
    public void removeProduct(Product product) {
        shopOrderDAO.removeProductFromOrder(orderId, product);
    }

}

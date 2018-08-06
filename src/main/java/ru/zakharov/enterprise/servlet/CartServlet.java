package ru.zakharov.enterprise.servlet;

import ru.zakharov.enterprise.dao.CartDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CartServlet extends HttpServlet {

    @Inject
    private CartDAO cartDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Collection<Product> productsInCart = cartDAO.getProductsInCart();
        req.setAttribute("productsInCart", productsInCart);
        req.getRequestDispatcher("WEB-INF/cart.jsp").forward(req,resp);
    }
}

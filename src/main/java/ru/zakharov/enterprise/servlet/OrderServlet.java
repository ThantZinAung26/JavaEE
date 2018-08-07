package ru.zakharov.enterprise.servlet;



import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.CartDAO;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private CartDAO cartDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String productId = req.getParameter(FieldConsts.ID);
        final Product product = productDAO.getProductById(productId);

        cartDAO.addProduct(productId);

        req.setAttribute(FieldConsts.PRODUCT, product);
        req.getRequestDispatcher("WEB-INF/order.jsp").forward(req,resp);
    }
}

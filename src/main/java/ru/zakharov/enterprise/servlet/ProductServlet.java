package ru.zakharov.enterprise.servlet;

import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProductServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String productId = req.getParameter(FieldConsts.ID);
        System.out.println("id= " + productId);
        final Product product = productDAO.getProductById(productId);

        if (productId ==  null || productId.equals("")) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.setAttribute(FieldConsts.PRODUCT, product);
        req.getRequestDispatcher("WEB-INF/product.jsp").forward(req,resp);
    }
}

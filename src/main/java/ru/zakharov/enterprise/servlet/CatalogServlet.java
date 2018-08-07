package ru.zakharov.enterprise.servlet;

import ru.zakharov.enterprise.constants.FieldConsts;
import ru.zakharov.enterprise.dao.ProductDAO;
import ru.zakharov.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CatalogServlet extends HttpServlet {

    @Inject
    private ProductDAO productDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Collection<Product> products = productDAO.getProducts();
        req.setAttribute(FieldConsts.PRODUCTS, products);
        req.getRequestDispatcher("WEB-INF/catalog.jsp").forward(req,resp);
    }
}

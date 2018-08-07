<%@ page import="ru.zakharov.enterprise.entity.Product" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ru.zakharov.enterprise.constants.FieldConsts" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/robotica/css/style.css">
    <title>Каталог Robotica</title>
</head>

<body>

<%
    final Object productsObject = request.getAttribute(FieldConsts.PRODUCTS);
    final Collection<Product> products = (Collection<Product>) productsObject;

%>

<div class="container">
    <jsp:include page="/WEB-INF/templates/header.jsp"/>
    <div class="content">
        <h2>Каталог</h2>
        <% for (Product product : products) { %>
        <div class="catalog">
            <div class="catalog_item">
                <div class="catalog_image">
                    <a href="/robotica/product?id=<%=product.getId()%>"><img class="catalog_img"
                                                                             src="/robotica/pictures/<%=product.getPicFileName()%>"
                                                                             alt="<%=product.getName()%>"></a>
                </div>
                <div class="calalog_link"><a href="/robotica/product?id=<%=product.getId()%>">Страница
                    товара <%=product.getName()%>
                </a></div>
            </div>
            <% } %>
        </div>
        <hr>
        <jsp:include page="/WEB-INF/templates/footer.jsp"/>
    </div>
</body>

</html>
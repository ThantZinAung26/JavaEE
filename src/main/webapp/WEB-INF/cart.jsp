<%@ page import="ru.zakharov.enterprise.entity.Product" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ru.zakharov.enterprise.constants.FieldConsts" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/robotica/css/style.css">
    <title>Корзина</title>
</head>
<body>
<%
    final Object cartObject = request.getAttribute(
            FieldConsts.PRODUCTS_IN_CART);
    final Collection<Product> productsInCart = (Collection<Product>) cartObject;

%>
<div class="container">
    <jsp:include page="/WEB-INF/templates/header.jsp"/>
    <p>Содержимое корзины заказов</p>
    <% for (Product product : productsInCart) { %>
    <p><%=product.getName()%>
    <%}%>
    </p>

    <jsp:include page="/WEB-INF/templates/footer.jsp"/>
</div>


</body>
</html>
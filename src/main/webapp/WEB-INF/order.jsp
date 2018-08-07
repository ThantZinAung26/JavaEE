<%@ page import="ru.zakharov.enterprise.entity.Product" %>
<%@ page import="ru.zakharov.enterprise.constants.FieldConsts" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/robotica/css/style.css">
    <title>Оформление заказа</title>
</head>

<%
    final Object productObject = request.getAttribute(FieldConsts.PRODUCT);
    final Product product = (Product) productObject;
%>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/templates/header.jsp"/>

    <div class="content">
        <p>Содержимое страницы заказа</p>
        <p>Вы добавили в корзину товар <%=product.getName()%></p>
    </div>
    <jsp:include page="/WEB-INF/templates/footer.jsp"/>
</div>
</body>
</html>
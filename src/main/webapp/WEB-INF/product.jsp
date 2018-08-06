<%@ page import="ru.zakharov.enterprise.entity.Product" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/robotica/css/style.css">
    <title>Интернет-магазин Robotica</title>
</head>


<div class="container">
    <jsp:include page="/WEB-INF/templates/header.jsp"/>

    <%
        final Object productObject = request.getAttribute("product");
        final Product product = (Product) productObject;
    %>

    <% if (product == null) { %>
    <p>Product not found!</p> <%
    } %>
    <div class="content">
        <h2><%=product.getName()%>
        </h2>

        <a href="/robotica/pictures/<%=product.getPicFileName()%>" target="_blank">
            <img class="borderedimg floating_left_img catalog_img"
                 src="/robotica/pictures/<%=product.getPicFileName()%>"
                 alt="Xiaomi Mi">
        </a>
        <p>
        <form action="/robotica/order" method="post">
            <input name="id" type="hidden" value="<%=product.getId()%>"/>
            <button class="buy_button" type="submit">Купить</button>
        </form>
        </p>
        <h3 class="description"> Краткое описание товара</h3>
        <p class="sdescription"><%=product.getShortDescription()%>
        </p>

        <h3 class="description">Подробное описание товара</h3>
        <p class="fdescription"><%=product.getFullDescription()%>/p>

        <hr>
    </div>
    <jsp:include page="/WEB-INF/templates/footer.jsp"/>
</div>

</html>
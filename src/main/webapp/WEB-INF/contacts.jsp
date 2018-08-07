<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/robotica/css/style.css">
    <title>Контакты Robotica</title>
</head>

<body>

<div class="container">
    <jsp:include page="/WEB-INF/templates/header.jsp"/>
    <div class="content">
        <hr>
        <h2>Напишите нам</h2>
        <form action="mailto:vh1@mail.ru" method="post" enctype="text/plain">
            <fieldset>
                <legend>Введите Ваши данные</legend>
                <input class="usertextfield" type="text" placeholder="Имя">
                <br>
                <input class="emailfield" type="text" placeholder="E-Mail">
                <br>
                <input class="usertextfield" type="text" placeholder="Тема">
                <br>
                <textarea name="textmessage" class="textmessagefield" wrap="hard" cols="30" rows="10"></textarea>
                <br>
                <input type="submit" value="Отправить">
                <input type="reset" value="Очистить">
                <br>
            </fieldset>
        </form>

        <h2>Адрес</h2>
        <p>Контактный номер телефона интернет-магазина +79094545644</p>
        <p>Адрес гор.Краснодар, ул. Песчаная д.9</p>
        <p>Email vh1@mail.ru</p>

        <h2>Где нас найти</h2>

        <!--Ссылка на Яндекс-Карты-->
        <iframe class="yandex_map" src="https://yandex.ru/map-widget/v1/-/CBuaJ4dUxB" frameborder="0"
                allowfullscreen="true"></iframe>
        <!--Конец ссылки на Яндекс-Карты-->
        <hr>
    </div>
    <jsp:include page="/WEB-INF/templates/footer.jsp"/>
</div>

</body>

</html>
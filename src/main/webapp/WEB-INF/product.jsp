<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/robotica/css/style.css">
    <title>Интернет-магазин Robotica</title>
    <script>
        function onClick() {
            alert("Вы только что купили этот товар!!")
        }
    </script>
</head>


<div class="container">
    <div class="header">
            <!--Меню в шапке-->
            <a href="/robotica/main"><img class="logo floating_left_img" src="/robotica/pictures/logo.png" alt="Robotica logo"></a>
            <ul class="menu">
                <li><a href="/robotica/main">Главная</a></li>
                <li><a href="/robotica/catalog">Каталог</a></li>
                <li><a href="/robotica/cart">Корзина</a></li>
                <li><a href="/robotica/order">Оформление заказа</a></li>
                <li><a href="/robotica/contacts">Контакты</a></li>
            </ul>
            <!--Конец меню в шапке-->

    </div>
    <div class="content">
        <h2>Робот - пылесос Xiaomi Mi Robot Vacuum Cleaner
</h2>

        <a href="../pictures/mi_large.jpg" target="_blank">
            <img class="borderedimg floating_left_img catalog_img" src="/robotica/pictures/mi_small.jpg" alt="Xiaomi Mi">
        </a>
        <p>
            <form action="">
                <button class="buy_button" onclick="onClick()">Купить</button>
            </form>
        </p>
        <h3 class="description"> Краткое описание товара</h3>
        <p class="sdescription">Робот пылесос - незаменимый помощник по дому в XXI веке. Робот-пылесос Xiaomi (mi) будет эффективно поддерживать чистоту полов в офисных или жилых помещениях любого размера без вашего участия.</p>

        <h3 class="description">Характеристики товара</h3>
        <p>Зависимоcть параметров уборки от скорости</p>
        <table class="descriptiontable">
            <tr class="tablehead">
                <td> </td>
                <td>Положение 1</td>
                <td>Положение 2</td>
                <td>Положение 3</td>
                <td>Положение 4</td>
            </tr>
            <tr>
                <td>Скорость уборки</td>
                <td rowspan="2">10%</td>
                <td>50%</td>
                <td>50%</td>
                <td>100%</td>
            </tr>
            <tr>
                <td>Качество уборки</td>

                <td colspan="2">50%</td>
                <td>100%</td>
            </tr>
            <tr>
                <td>Уровень фильтрации пыли</td>
                <td>100%</td>
                <td>75%</td>
                <td>50%</td>
                <td>25%</td>
            </tr>
        </table>

        <ul class="itemdescrlist">
            <li>Уборка: сухая </li>
            <li>Боковая щетка: есть </li>
            <li>Мягкий бампер: есть </li>
            <li>Пылесборник: без мешка (циклонный фильтр) </li>
            <li>Интерфейс: Wi-Fi </li>
        </ul>


        <h3 class="description">Подробное описание товара</h3>
        <p class="fdescription">Для создания карты и выбора оптимального маршрута уборки робот-пылесос использует инновационную систему лазерного дальномера и сенсоров. Всего ориентироваться в пространстве ему помогают 12 инфракрасных и ультразвуковых датчиков. Уборка пыли происходит по технологии инерционного перемещения с вакуумной фильтрацией. Для этого используются две щетки и 1 упругий скребок.</p>

        <p>Литий-ионный аккумулятор емкостью 5200 мА·ч обеспечивает длительную работу без подзарядки – до 2,5 часов. При разряде батареи робот автоматически заряжается при помощи комплектной док-станции. Убранный мусор скапливается в пылесборнике из пластика, никаких мешков – просто вытряхнули контейнер и все. В приложении можно задать время и дни недели для уборки, а также контролировать ее эффективность, вносить коррективы.</p>

        <hr>
    </div>
    <div class="footer">
        <hr>
        <!--Началало подвала-->
        <div class="footertext">
            <p>&copy; Все права защищены.</p>
        </div>
        <!--Конец подвала-->
    </div>
</div>

</html>
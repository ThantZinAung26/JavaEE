package ru.zakharov.enterprise.dao;

import ru.zakharov.enterprise.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class ProductDAO {

    private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        addProduct(new Product("Робот - пылесос Xiaomi Mi Robot Vacuum Cleaner ",
                "Робот пылесос - незаменимый помощник по дому в XXI веке.",
                "Для создания карты и выбора оптимального маршрута уборки " +
                        "робот-пылесос использует инновационную систему лазерного дальномера и сенсоров. " +
                        "Всего ориентироваться в пространстве ему помогают 12 инфракрасных и ультразвуковых датчиков." +
                        "Уборка пыли происходит по технологии инерционного перемещения с вакуумной фильтрацией. " +
                        "Для этого используются две щетки и 1 упругий скребок.\n" +
                        "Литий-ионный аккумулятор емкостью 5200 мА·ч обеспечивает длительную работу без подзарядки – до 2,5 часов. " +
                        "При разряде батареи робот автоматически заряжается при помощи комплектной док-станции. " +
                        "Убранный мусор скапливается в пылесборнике из пластика, никаких мешков – просто вытряхнули контейнер и все. " +
                        "В приложении можно задать время и дни недели для уборки, а также контролировать ее эффективность, вносить коррективы.",
                20000,
                "mi_large.jpg"));

        addProduct(new Product("робот-пылесос Gutrend Smart 300",
                "Робот-пылесос GUTREND SMART 300 - это интеллектуальный подход к ежедневной уборке.",
                "Под элегантным корпусом кроются технологии, которые могут переписать Ваш опыт в наведении порядка.\n" +
                        "Новый GUTREND SMART 300 предназначен как для сухой, так и для влажной уборки всех типов напольных покрытий.\n" +
                        "Благодаря технологии OPTIMAL ROUTE робот-пылесос SMART 300 обеспечивает последовательную уборку помещения, " +
                        "избегая повторного прохождения ранее очищенной поверхности, и сокращая тем самым необходимое для качественной уборки время.\n" +
                        "Усовершенствованная технология влажной уборки с автоматической подачей воды неспроста получила название SMART DRIP 2.0. " +
                        "Ведь за четкое дозирование поступающей жидкости во время уборки отныне отвечает надежная электронная система, " +
                        "которая гарантированно прекращает подачу воды во время остановки пылесоса.",
                28490,
                "gutrend.jpg"));
    }

    public void addProduct(Product product) {
        if (product != null && product.getId() != null) {
            products.put(product.getId(), product);
        }
    }

    public Product getProductById(String productId) {
        if (productId != null)
            return products.get(productId);
        else return null;
    }

    public Collection<Product> getProducts() {
        return products.values();
    }


}

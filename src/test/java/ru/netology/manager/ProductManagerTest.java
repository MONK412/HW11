package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product product1 = new Book(17, "Властелин колец", 4900, "Дж.Р.Толкиен");
    Product product2 = new Book(346, "Лучшее в нас", 1200, "Стивен Пинкер");
    Product product3 = new Smartphone(7264, "Samsung Galaxy", 76000, "Samsung");
    Product product4 = new Smartphone(8016, "Sony Erikson", 64300, "Sony");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldAddProducts() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind2Products() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy("S");
        Product[] expected = {product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProducts() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy("p");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind4ProductsBecauseSpace() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy(" ");
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }
}

package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    Product product1 = new Book(17, "Властелин колец", 4900, "Дж.Р.Толкиен");
    Product product2 = new Book(346, "Лучшее в нас", 1200, "Стивен Пинкер");
    Product product3 = new Smartphone(7264, "Samsung Galaxy", 76000, "Samsung");
    Product product4 = new Smartphone(8016, "Sony Erikson", 64300, "Sony");

    ProductRepository repo = new ProductRepository();

    @Test
    public void howWillSaveAndFind() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeId() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(346);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }
}

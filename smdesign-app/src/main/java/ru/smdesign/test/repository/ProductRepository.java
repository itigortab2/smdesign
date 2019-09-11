package ru.smdesign.test.repository;

import ru.smdesign.test.entity.Product;

import java.util.List;


public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(String id);

    public Product saveProduct(Product product);

    public List<Product> findByName(String name);

    public List<Product> findByParameterKeyAndValue(String key, String value);

    public void deleteAll();
}

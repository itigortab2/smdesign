package ru.smdesign.test.service;

import ru.smdesign.test.entity.Product;

import java.util.List;
import java.util.Optional;

public interface WebServiceAdapter {
    public List<Product> findByName(Object request);

    public Optional<Product> getProduct(String id);

    public List<Product> findAll();

    public Product addProduct(Product product);

    public List<Product> findByParameterKeyAndValue(String key, String value);
}

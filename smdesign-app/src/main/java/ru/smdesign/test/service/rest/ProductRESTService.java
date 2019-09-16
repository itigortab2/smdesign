package ru.smdesign.test.service.rest;

import ru.smdesign.test.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRESTService {

    public List<Product> findByName(String name);

    public Optional<Product> getProduct(String id);

    public List<Product> findAll();

    public Product addProduct(Product product);

    public List<Product> findByParameterKeyAndValue(String key, String value);

}

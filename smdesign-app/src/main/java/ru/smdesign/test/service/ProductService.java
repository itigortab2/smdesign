package ru.smdesign.test.service;

import ru.smdesign.test.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public List<Product> findByName(String name);

    public Product getProduct(String id);

    public List<Product> findAll();

    public Product addProduct(String name, String description, Map<String, String> parametres);

    public Product addProduct(Product product);

    public List<Product> findByParameterKeyAndValue(String key, String value);

}

package ru.smdesign.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByParameterKeyAndValue(String key, String value) {
        Map<String, String> params = new HashMap<>();
        params.put(key, value);
        Example<Product> productExample = Example.of(new Product(null, null, params),
                ExampleMatcher.matchingAll());
        return productRepository.findAll(productExample);
    }

    @Override
    public List<Product> findAll() { return  productRepository.findAll(); }

    @Override
    public Product addProduct(String name, String description, Map<String, String> parametres) {
        Product product = new Product(name, description, parametres);
        return productRepository.insert(product);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.insert(product);
    }
}

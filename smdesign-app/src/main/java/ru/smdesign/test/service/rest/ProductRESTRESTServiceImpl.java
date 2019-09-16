package ru.smdesign.test.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRESTRESTServiceImpl implements ProductRESTService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(String id) {
        return Optional.of(productRepository.findById(id));
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByParameterKeyAndValue(String key, String value) {

        return productRepository.findByParameterKeyAndValue(key, value);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.saveProduct(product);
    }
}

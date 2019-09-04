package ru.smdesign.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.repository.ProductRepository;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAll();
    }
}

package ru.smdesign.test.service.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.repository.ProductRepository;
import ru.smdesign.test.service.rest.ProductRESTService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSOAPRESTServiceImpl implements ProductSOAPService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}

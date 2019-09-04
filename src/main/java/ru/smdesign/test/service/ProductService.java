package ru.smdesign.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.repository.ProductRepository;

import java.util.List;

public interface ProductService {

    public List<Product> findByName(String name);

}

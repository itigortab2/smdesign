package ru.smdesign.test.service.soap;

import ru.smdesign.test.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSOAPService {

    public List<Product> findByName(String name);

}

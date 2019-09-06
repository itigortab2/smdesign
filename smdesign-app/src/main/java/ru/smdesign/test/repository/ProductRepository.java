package ru.smdesign.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.smdesign.test.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findByName(String name);
}

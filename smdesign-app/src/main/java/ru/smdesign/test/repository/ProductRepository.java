package ru.smdesign.test.repository;

import org.springframework.stereotype.Repository;
import ru.smdesign.test.entity.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findByName(String name);

}

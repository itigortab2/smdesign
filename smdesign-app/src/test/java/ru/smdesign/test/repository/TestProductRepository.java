package ru.smdesign.test.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.smdesign.test.entity.Param;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.service.ProductService;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductRepository {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void init() {
        productRepository.deleteAll();
        addProducts();
    }

    @Test
    public void findByNameTest() {

       List<Product> products = productRepository.findByName("title1");
       assertEquals(1, products.size());
        List<Product> notProducts = productRepository.findByName("title0");
        assertEquals(0, notProducts.size());
    }

    @Test
    public void findByAllTest() {
        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size());
    }

    @Test
    public void findById() {
        Product productResult = productRepository.findAll().get(0);
        Product finderProduct = productRepository.findById(productResult.getId());
        assertEquals(productResult, finderProduct);
    }

    @Test
    public void findByParameter() {
        String key = "key1";
        String value = "value1";
        List<Product> products = productRepository.findByParameterKeyAndValue(key, value);
        assertEquals(1, products.size());
    }

    private void addProducts() {
        Param param = new Param("key1", "value1");
        Product product = new Product("title1","description1",
                Collections.singleton(param));
        Param param1 = new Param("key2", "value2");
        Product product1 =
                new Product("title2", "description2", Collections.singleton(param1));

        productRepository.saveProduct(product);
        productRepository.saveProduct(product1);
    }


}

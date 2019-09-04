package ru.smdesign.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findByName("");
    }

}

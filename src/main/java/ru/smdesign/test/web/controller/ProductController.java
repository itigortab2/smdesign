package ru.smdesign.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.service.ProductService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add_product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        if (addedProduct == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(addedProduct.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(addedProduct);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> read(@PathVariable("id") String id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
    }

    @GetMapping("/filter_params/{key}/{value}")
    public ResponseEntity<List<Product>> getProductsByParamKeyAndValue(@PathVariable("key") String key,
                                                       @PathVariable("value") String value) {
        return new ResponseEntity<List<Product>>(
                productService.findByParameterKeyAndValue(key, value), HttpStatus.OK);
    }

    @GetMapping("/filter_name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(productService.findByName(name), HttpStatus.OK);
    }

}

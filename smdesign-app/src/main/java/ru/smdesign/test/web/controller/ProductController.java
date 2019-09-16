package ru.smdesign.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.service.rest.ProductRESTService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductRESTService productRESTService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productRESTService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add_product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productRESTService.addProduct(product);
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

    @GetMapping("/{id}")
    public ResponseEntity<Product> read(@PathVariable("id") String id) {
        Product product = productRESTService.getProduct(id).get();
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/filter_params/{key}/{value}")
    public ResponseEntity<List<Product>> getProductsByParamKeyAndValue(@PathVariable("key") String key,
                                                                       @PathVariable("value") String value) {
        return new ResponseEntity<List<Product>>(
                productRESTService.findByParameterKeyAndValue(key, value), HttpStatus.OK);
    }

    @GetMapping("/filter_name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@RequestPayload String json) {
        return new ResponseEntity<List<Product>>(productRESTService.findByName(json), HttpStatus.OK);
    }

}

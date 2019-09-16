package ru.smdesign.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.service.rest.ProductRESTService;
import ru.smdesign.test.soap.function.GetProductByNameRequest;

import java.util.List;
import java.util.Optional;

@Service
public class WebServiceAdapterSOAPImpl implements WebServiceAdapter {

    @Autowired
    ProductRESTService productRESTService;

    @Override
    public List<Product> findByName(Object request) {
        GetProductByNameRequest request1 = (GetProductByNameRequest) request;
        return productRESTService.findByName(request1.getName());
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> findByParameterKeyAndValue(String key, String value) {
        return null;
    }
}

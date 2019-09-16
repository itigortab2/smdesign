package ru.smdesign.test.soap.factory;

import ru.smdesign.test.entity.Param;
import ru.smdesign.test.entity.Product;
import ru.smdesign.test.soap.function.GetProductByNameRequest;
import ru.smdesign.test.soap.function.GetProductByNameResponse;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {}

    public GetProductByNameRequest createGetProductByNameRequest() {
        return new GetProductByNameRequest();
    }

    public GetProductByNameResponse createGetProductByNameResponse() {
        return new GetProductByNameResponse();
    }

    public Product createProduct() {
        return new Product();
    }

    public Param createParam() {
        return new Param();
    }

}

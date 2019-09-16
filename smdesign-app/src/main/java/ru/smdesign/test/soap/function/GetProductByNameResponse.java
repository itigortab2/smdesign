package ru.smdesign.test.soap.function;

import ru.smdesign.test.entity.Product;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "product"
})
@XmlRootElement(
        name = "getProductByNameResponse")
public class GetProductByNameResponse {

    @XmlElement(required = true)
    protected Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product value) {
        this.product = value;
    }

}

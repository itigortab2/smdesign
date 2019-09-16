package ru.smdesign.test.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
        "id",
        "name",
        "description",
        "parametres"
})
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @XmlElement(required = true)
    private String id;
    @XmlElement(required = true)
    private String name;
    private String description;

    @XmlElement(required = true)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Param> parametres = new HashSet<>();

    public Product(String name, String description, Set<Param> parametres) {
        this.name = name;
        this.description = description;
        this.parametres = parametres;
    }

    public Product() {
    }

    public Set<Param> getParametres() {
        return parametres;
    }

    public void setParametres(Set<Param> parametres) {
        this.parametres = parametres;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(parametres, product.parametres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, parametres);
    }
}

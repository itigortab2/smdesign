package ru.smdesign.test.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String description;

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
}

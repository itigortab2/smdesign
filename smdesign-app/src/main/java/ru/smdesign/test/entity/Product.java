package ru.smdesign.test.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document
public class Product {

    @Id
    private String id;
    @Indexed
    private String name;
    private String description;

    @Indexed
    private Map<String, String> parametres = new HashMap<>();

    public Product(String name, String description, Map<String, String> parametres) {
        this.name = name;
        this.description = description;
        this.parametres = parametres;
    }

    public Map<String, String> getParametres() {
        return parametres;
    }

    public void setParametres(Map<String, String> parametres) {
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

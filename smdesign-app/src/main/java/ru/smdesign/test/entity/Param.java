package ru.smdesign.test.entity;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Param {

    private String key;
    private String value;

    public Param(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Param() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            Param param = (Param) o;
            if (param.key.equals(this.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

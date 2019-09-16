package ru.smdesign.test.entity;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "param", propOrder = {
        "key",
        "value"
})
public class Param {

    @XmlElement(required = true)
    private String key;
    @XmlElement(required = true)
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

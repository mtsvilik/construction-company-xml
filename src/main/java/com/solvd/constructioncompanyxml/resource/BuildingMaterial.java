package com.solvd.constructioncompanyxml.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class BuildingMaterial {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "quantity")
    private int quantity;

    public BuildingMaterial() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BuildingMaterial{" +
                "title='" + title + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

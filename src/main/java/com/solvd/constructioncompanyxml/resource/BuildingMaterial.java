package com.solvd.constructioncompanyxml.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BuildingMaterial {

    private String title;
    private int quantity;

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

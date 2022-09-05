package com.solvd.constructioncompanyxml.project;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.constructioncompanyxml.parser.jaxb.BigDecimalAdapter;
import com.solvd.constructioncompanyxml.parser.jaxb.LocalDateAdapter;
import com.solvd.constructioncompanyxml.parser.json.BigDecimalDeserializer;
import com.solvd.constructioncompanyxml.parser.json.DateDeserializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

    @XmlElement(name = "title")
    private String title;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate foundationDate;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    private BigDecimal price;

    @XmlElement(name = "square")
    private Integer square;

    @XmlElement(name = "numberOfRooms")
    private Integer numberOfRooms;

    public Project() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", foundationDate=" + foundationDate +
                ", price=" + price +
                ", square=" + square +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}

package com.solvd.constructioncompanyxml.resource;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.constructioncompanyxml.parser.jaxb.LocalDateAdapter;
import com.solvd.constructioncompanyxml.parser.json.DateDeserializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {

    @XmlElement(name = "title")
    private String title;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate dateOfRelease;

    public Equipment() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "title='" + title + '\'' +
                ", dateOfRelease=" + dateOfRelease +
                '}';
    }
}

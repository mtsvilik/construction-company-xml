package com.solvd.constructioncompanyxml.info;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.constructioncompanyxml.parser.jaxb.LocalDateAdapter;
import com.solvd.constructioncompanyxml.parser.json.DateDeserializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Passport {

    private Integer passportNumber;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate dateOfIssue;

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportNumber=" + passportNumber +
                ", dateOfIssue=" + dateOfIssue +
                '}';
    }
}

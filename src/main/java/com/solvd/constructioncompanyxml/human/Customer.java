package com.solvd.constructioncompanyxml.human;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.constructioncompanyxml.info.Address;
import com.solvd.constructioncompanyxml.info.Passport;
import com.solvd.constructioncompanyxml.parser.jaxb.BigDecimalAdapter;
import com.solvd.constructioncompanyxml.parser.json.BigDecimalDeserializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlElement(name = "firstName")
    private String firstName;

    @XmlElement(name = "lastName")
    private String lastName;

    @XmlElement(name = "address")
    private Address address;

    @XmlElement(name = "passport")
    private Passport passport;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    private BigDecimal budget;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", passport=" + passport +
                ", budget=" + budget +
                '}';
    }
}

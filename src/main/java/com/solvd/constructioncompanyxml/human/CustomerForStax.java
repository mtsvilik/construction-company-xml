package com.solvd.constructioncompanyxml.human;

import com.solvd.constructioncompanyxml.info.Passport;

import java.math.BigDecimal;

public class CustomerForStax {

    private String firstName;
    private String lastName;
    private Passport passport;
    private BigDecimal budget;

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

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport=" + passport +
                ", budget=" + budget +
                '}';
    }
}

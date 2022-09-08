package com.solvd.constructioncompanyxml.info;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.constructioncompanyxml.parser.jaxb.LocalDateAdapter;
import com.solvd.constructioncompanyxml.parser.json.DateDeserializer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccount {

    private Integer accountNumber;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate dateOfCreate;

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", dateOfCreate=" + dateOfCreate +
                '}';
    }
}

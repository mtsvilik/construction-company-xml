package com.solvd.constructioncompanyxml.company;

import com.solvd.constructioncompanyxml.human.CustomerForStax;
import com.solvd.constructioncompanyxml.info.BankAccount;
import com.solvd.constructioncompanyxml.resource.BuildingMaterial;

import java.util.List;

public class CompanyForStax {

    private String name;
    private BankAccount bankAccount;
    private List<CustomerForStax> customers;
    private List<BuildingMaterial> buildingMaterials;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<CustomerForStax> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerForStax> customers) {
        this.customers = customers;
    }

    public List<BuildingMaterial> getBuildingMaterials() {
        return buildingMaterials;
    }

    public void setBuildingMaterials(List<BuildingMaterial> buildingMaterials) {
        this.buildingMaterials = buildingMaterials;
    }

    @Override
    public String toString() {
        return "CompanyForStax{" +
                "name='" + name + '\'' +
                ", bankAccount=" + bankAccount +
                ", customers=" + customers +
                ", buildingMaterials=" + buildingMaterials +
                '}';
    }
}

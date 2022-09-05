package com.solvd.constructioncompanyxml.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.constructioncompanyxml.human.Customer;
import com.solvd.constructioncompanyxml.human.Employee;
import com.solvd.constructioncompanyxml.info.Address;
import com.solvd.constructioncompanyxml.info.BankAccount;
import com.solvd.constructioncompanyxml.project.Project;
import com.solvd.constructioncompanyxml.resource.BuildingMaterial;
import com.solvd.constructioncompanyxml.resource.Equipment;
import com.solvd.constructioncompanyxml.resource.Vehicle;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

    @XmlAttribute
    private String name;

    @XmlElement(name = "address")
    private Address address;

    @XmlElement(name = "bankAccount")
    private BankAccount bankAccount;

    @XmlElementWrapper(name = "customers")
    @XmlElement(name = "customer")
    @JsonProperty("customers")
    private List<Customer> customers;

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    @JsonProperty("employees")
    private List<Employee> employees;

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    @JsonProperty("projects")
    private List<Project> projects;

    @XmlElementWrapper(name = "buildingMaterials")
    @XmlElement(name = "buildingMaterial")
    @JsonProperty("buildingMaterials")
    private List<BuildingMaterial> buildingMaterials;

    @XmlElementWrapper(name = "equipments")
    @XmlElement(name = "equipment")
    @JsonProperty("equipments")
    private List<Equipment> equipments;

    @XmlElementWrapper(name = "vehicles")
    @XmlElement(name = "vehicle")
    @JsonProperty("vehicles")
    private List<Vehicle> vehicles;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<BuildingMaterial> getBuildingMaterials() {
        return buildingMaterials;
    }

    public void setBuildingMaterials(List<BuildingMaterial> buildingMaterials) {
        this.buildingMaterials = buildingMaterials;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", bankAccount=" + bankAccount +
                ", customers=" + customers +
                ", employees=" + employees +
                ", projects=" + projects +
                ", buildingMaterials=" + buildingMaterials +
                ", equipments=" + equipments +
                ", vehicles=" + vehicles +
                '}';
    }
}

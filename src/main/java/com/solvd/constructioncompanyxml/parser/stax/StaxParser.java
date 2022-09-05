package com.solvd.constructioncompanyxml.parser.stax;

import com.solvd.constructioncompanyxml.company.Company;
import com.solvd.constructioncompanyxml.human.Customer;
import com.solvd.constructioncompanyxml.human.Employee;
import com.solvd.constructioncompanyxml.info.Address;
import com.solvd.constructioncompanyxml.info.BankAccount;
import com.solvd.constructioncompanyxml.info.Passport;
import com.solvd.constructioncompanyxml.parser.IParser;
import com.solvd.constructioncompanyxml.project.Project;
import com.solvd.constructioncompanyxml.resource.BuildingMaterial;
import com.solvd.constructioncompanyxml.resource.Equipment;
import com.solvd.constructioncompanyxml.resource.Vehicle;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaxParser implements IParser {

    @Override
    public Company parse(String fileName) throws FileNotFoundException, XMLStreamException {

        Company company = new Company();
        String text = "";
        Address address = new Address();
        Passport passport = new Passport();
        BankAccount bankAccount = new BankAccount();
        Customer customer = new Customer();
        Employee employee = new Employee();
        Project project = new Project();
        BuildingMaterial buildingMaterial = new BuildingMaterial();
        Equipment equipment = new Equipment();
        Vehicle vehicle = new Vehicle();
        List<Customer> customers = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        List<BuildingMaterial> buildingMaterials = new ArrayList<>();
        List<Equipment> equipments = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();

        XMLStreamReader xmlReader = XMLInputFactory.newInstance()
                .createXMLStreamReader(new FileInputStream(fileName));
        while (xmlReader.hasNext()) {
            switch (xmlReader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (xmlReader.getLocalName()) {
                        case "company":
                            company = new Company();
                            company.setName(xmlReader.getAttributeValue(0));
                            break;
                        case "address":
                            address = new Address();
                            company.setAddress(address);
                            customer.setAddress(address);
                            employee.setAddress(address);
                            break;
                        case "bankAccount":
                            bankAccount = new BankAccount();
                            company.setBankAccount(bankAccount);
                            break;
                        case "customer":
                            customer = new Customer();
                            customers.add(customer);
                            company.setCustomers(customers);
                            break;
                        case "passport":
                            passport = new Passport();
                            customer.setPassport(passport);
                            employee.setPassport(passport);
                        case "employee":
                            employee = new Employee();
                            employees.add(employee);
                            company.setEmployees(employees);
                            break;
                        case "project":
                            project = new Project();
                            projects.add(project);
                            company.setProjects(projects);
                            break;
                        case "buildingMaterial":
                            buildingMaterial = new BuildingMaterial();
                            buildingMaterials.add(buildingMaterial);
                            company.setBuildingMaterials(buildingMaterials);
                            break;
                        case "equipment":
                            equipment = new Equipment();
                            equipments.add(equipment);
                            company.setEquipments(equipments);
                            break;
                        case "vehicle":
                            vehicle = new Vehicle();
                            vehicles.add(vehicle);
                            company.setVehicles(vehicles);
                            break;
                        default:
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    text = xmlReader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (xmlReader.getLocalName()) {
                        case "city":
                            address.setCity(text);
                            break;
                        case "street":
                            address.setStreet(text);
                            break;
                        case "houseNumber":
                            address.setHouseNumber(Integer.parseInt(text));
                            break;
                        case "accountNumber":
                            bankAccount.setAccountNumber(Integer.parseInt(text));
                            break;
                        case "dateOfCreate":
                            bankAccount.setDateOfCreate(LocalDate.parse(text));
                            break;
                        case "firstName":
                            customer.setFirstName(text);
                            employee.setFirstName(text);
                            break;
                        case "lastName":
                            customer.setLastName(text);
                            employee.setLastName(text);
                            break;
                        case "passportNumber":
                            passport.setPassportNumber(Integer.parseInt(text));
                            break;
                        case "dateOfIssue":
                            passport.setDateOfIssue(LocalDate.parse(text));
                            break;
                        case "budget":
                            customer.setBudget(BigDecimal.valueOf(Long.parseLong((text))));
                            break;
                        case "position":
                            employee.setPosition(text);
                            break;
                        case "salary":
                            employee.setSalary(BigDecimal.valueOf(Long.parseLong(text)));
                            break;
                        case "title":
                            project.setTitle(text);
                            buildingMaterial.setTitle(text);
                            equipment.setTitle(text);
                            break;
                        case "foundationDate":
                            project.setFoundationDate(LocalDate.parse(text));
                            break;
                        case "price":
                            project.setPrice(BigDecimal.valueOf(Long.parseLong(text)));
                            break;
                        case "square":
                            project.setSquare(Integer.parseInt(text));
                            break;
                        case "numbersOfRooms":
                            project.setNumberOfRooms(Integer.parseInt(text));
                            break;
                        case "quantity":
                            buildingMaterial.setQuantity(Integer.parseInt(text));
                            break;
                        case "dateOfRelease":
                            equipment.setDateOfRelease(LocalDate.parse(text));
                            vehicle.setDateOfRelease(LocalDate.parse(text));
                            break;
                        case "engine":
                            vehicle.setEngine(text);
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        return company;
    }
}
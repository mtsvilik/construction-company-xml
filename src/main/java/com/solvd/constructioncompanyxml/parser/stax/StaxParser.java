package com.solvd.constructioncompanyxml.parser.stax;

import com.solvd.constructioncompanyxml.company.CompanyForStax;
import com.solvd.constructioncompanyxml.human.CustomerForStax;
import com.solvd.constructioncompanyxml.info.BankAccount;
import com.solvd.constructioncompanyxml.info.Passport;
import com.solvd.constructioncompanyxml.parser.IParserForStax;
import com.solvd.constructioncompanyxml.resource.BuildingMaterial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class StaxParser implements IParserForStax {

    private static final Logger LOGGER = LogManager.getLogger(StaxParser.class);

    @Override
    public CompanyForStax parse(String fileName) {

        CompanyForStax company = new CompanyForStax();
        String tagContent = "";
        Passport passport = new Passport();
        BankAccount bankAccount = new BankAccount();
        CustomerForStax customer = new CustomerForStax();
        BuildingMaterial buildingMaterial = new BuildingMaterial();
        List<CustomerForStax> customers = new ArrayList<>();
        List<BuildingMaterial> buildingMaterials = new ArrayList<>();

        XMLStreamReader xmlReader = null;
        try {
            xmlReader = XMLInputFactory.newInstance()
                    .createXMLStreamReader(new FileInputStream(fileName));
            while (xmlReader.hasNext()) {
                switch (xmlReader.next()) {
                    case XMLStreamConstants.START_ELEMENT:
                        switch (xmlReader.getLocalName()) {
                            case "company":
                                company = new CompanyForStax();
                                company.setName(xmlReader.getAttributeValue(0));
                                break;
                            case "bankAccount":
                                bankAccount = new BankAccount();
                                company.setBankAccount(bankAccount);
                                break;
                            case "customer":
                                customer = new CustomerForStax();
                                customers.add(customer);
                                company.setCustomers(customers);
                                break;
                            case "passport":
                                passport = new Passport();
                                customer.setPassport(passport);
                                break;
                            case "buildingMaterial":
                                buildingMaterial = new BuildingMaterial();
                                buildingMaterials.add(buildingMaterial);
                                company.setBuildingMaterials(buildingMaterials);
                                break;
                            default:
                                break;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = xmlReader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (xmlReader.getLocalName()) {
                            case "accountNumber":
                                bankAccount.setAccountNumber(Integer.parseInt(tagContent));
                                break;
                            case "dateOfCreate":
                                bankAccount.setDateOfCreate(LocalDate.parse(tagContent));
                                break;
                            case "firstName":
                                customer.setFirstName(tagContent);
                                break;
                            case "lastName":
                                customer.setLastName(tagContent);
                                break;
                            case "passportNumber":
                                passport.setPassportNumber(Integer.parseInt(tagContent));
                                break;
                            case "dateOfIssue":
                                passport.setDateOfIssue(LocalDate.parse(tagContent));
                                break;
                            case "budget":
                                customer.setBudget(BigDecimal.valueOf(Long.parseLong((tagContent))));
                                break;
                            case "title":
                                buildingMaterial.setTitle(tagContent);
                                break;
                            case "quantity":
                                buildingMaterial.setQuantity(Integer.parseInt(tagContent));
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException | FileNotFoundException ex) {
            LOGGER.error(ex);
        }
        return company;
    }
}
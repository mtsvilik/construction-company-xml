package com.solvd.constructioncompanyxml.parser.jaxb;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements IParser {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    @Override
    public Company parse(String fileName) {
        Company companyJaxb = new Company();

        try {
            JAXBContext context = JAXBContext
                    .newInstance(Company.class, Customer.class, Employee.class, Address.class, BankAccount.class,
                            Passport.class, Project.class, BuildingMaterial.class, Equipment.class, Vehicle.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            companyJaxb = (Company) unmarshaller.unmarshal(new File(fileName));

        } catch (JAXBException ex) {
            LOGGER.error(ex);
        }
        return companyJaxb;
    }
}

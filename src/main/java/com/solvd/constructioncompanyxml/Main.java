package com.solvd.constructioncompanyxml;

import com.solvd.constructioncompanyxml.company.Company;
import com.solvd.constructioncompanyxml.parser.IParser;
import com.solvd.constructioncompanyxml.parser.jaxb.JaxbParser;
import com.solvd.constructioncompanyxml.parser.json.JsonParser;
import com.solvd.constructioncompanyxml.parser.stax.StaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;


public class Main {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        IParser parser = new StaxParser();
        Company company;

        IParser parserJaxb = new JaxbParser();
        Company companyJaxb;

        IParser parserJson = new JsonParser();
        Company companyJson;

        try {
            company = parser.parse("src/main/resources/constructioncompany.xml");
            LOGGER.info("Stax parser: " + company);

            companyJaxb = parserJaxb.parse("src/main/resources/constructioncompany.xml");
            LOGGER.info("Jaxb parser: " + companyJaxb);

            companyJson = parserJson.parse("src/main/resources/constructioncompany.json");
            LOGGER.info("Json parser: " + companyJson);

        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
    }
}

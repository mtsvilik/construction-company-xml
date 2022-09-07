package com.solvd.constructioncompanyxml;

import com.solvd.constructioncompanyxml.company.Company;
import com.solvd.constructioncompanyxml.company.CompanyForStax;
import com.solvd.constructioncompanyxml.parser.IParser;
import com.solvd.constructioncompanyxml.parser.IParserForStax;
import com.solvd.constructioncompanyxml.parser.jaxb.JaxbParser;
import com.solvd.constructioncompanyxml.parser.json.JsonParser;
import com.solvd.constructioncompanyxml.parser.stax.StaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        IParserForStax parser = new StaxParser();
        IParser parserJaxb = new JaxbParser();
        IParser parserJson = new JsonParser();

        CompanyForStax companyForStax = parser.parse("src/main/resources/companyforstax.xml");
        LOGGER.info("Stax parser: " + companyForStax);

        Company companyJaxb = parserJaxb.parse("src/main/resources/companyforjaxb.xml");
        LOGGER.info("Jaxb parser: " + companyJaxb);

        Company companyJson = parserJson.parse("src/main/resources/company.json");
        LOGGER.info("Json parser: " + companyJson);
    }
}

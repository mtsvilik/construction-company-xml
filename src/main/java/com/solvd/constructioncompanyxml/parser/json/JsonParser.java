package com.solvd.constructioncompanyxml.parser.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.constructioncompanyxml.company.Company;
import com.solvd.constructioncompanyxml.parser.IParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;

public class JsonParser implements IParser {

    private static final Logger LOGGER = LogManager.getLogger(JsonParser.class);

    @Override
    public Company parse(String fileName) {
        Company company = new Company();
        ObjectMapper mapper = new ObjectMapper();

        try {
            company = mapper.readValue(Paths.get(fileName).toFile(), Company.class);
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
        return company;
    }
}

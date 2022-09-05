package com.solvd.constructioncompanyxml.parser.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.constructioncompanyxml.company.Company;
import com.solvd.constructioncompanyxml.parser.IParser;

import java.nio.file.Paths;

public class JsonParser implements IParser {
    @Override
    public Company parse(String fileName) {
        Company company = new Company();
        ObjectMapper mapper = new ObjectMapper();

        try {
            company = mapper.readValue(Paths.get(fileName).toFile(), Company.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return company;
    }
}

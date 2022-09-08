package com.solvd.constructioncompanyxml.parser;

import com.solvd.constructioncompanyxml.company.CompanyForStax;

public interface IParserForStax {

    CompanyForStax parse(String fileName);

}

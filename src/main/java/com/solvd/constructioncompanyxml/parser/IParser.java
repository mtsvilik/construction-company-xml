package com.solvd.constructioncompanyxml.parser;

import com.solvd.constructioncompanyxml.company.Company;

public interface IParser {

    Company parse(String fileName);

}

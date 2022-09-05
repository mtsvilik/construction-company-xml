package com.solvd.constructioncompanyxml.parser;

import com.solvd.constructioncompanyxml.company.Company;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface IParser {

    Company parse(String fileName) throws IOException, XMLStreamException;

}

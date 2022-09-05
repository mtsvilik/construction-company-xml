package com.solvd.constructioncompanyxml.parser.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String xmlDate) throws Exception {
        return LocalDate.parse(xmlDate);
    }

    @Override
    public String marshal(LocalDate xmlDate) throws Exception {
        return xmlDate.toString();
    }
}

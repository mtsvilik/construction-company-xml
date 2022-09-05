package com.solvd.constructioncompanyxml.parser.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public BigDecimal unmarshal(String s) throws Exception {
        return new BigDecimal(s);
    }

    @Override
    public String marshal(BigDecimal xmlBigDecimal) throws Exception {
        if (xmlBigDecimal != null) {
            return xmlBigDecimal.toString();
        }
        return null;
    }
}

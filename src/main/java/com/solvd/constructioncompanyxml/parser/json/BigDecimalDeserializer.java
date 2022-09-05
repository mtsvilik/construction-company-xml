package com.solvd.constructioncompanyxml.parser.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalDeserializer extends StdDeserializer<BigDecimal> {

    protected BigDecimalDeserializer() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return BigDecimal.valueOf(Long.parseLong(jsonParser.readValueAs(String.class)));
    }
}


package com.binadox.qa;

import com.binadox.qa.dto.AbstractClass;
import com.binadox.qa.dto.Child1;
import com.binadox.qa.dto.Child2;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class AbstractClassDeserializaer extends StdDeserializer<AbstractClass> {
    public AbstractClassDeserializaer() {
        this(null);
    }

    public AbstractClassDeserializaer(final Class<?> vc) {
        super(vc);
    }

    public AbstractClass deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        if (node.has("string")) {
            return mapper.treeToValue(node, Child1.class);
        } else if (node.has("innerChild2s")) {
            return mapper.treeToValue(node, Child2.class);
        }
        return null;
    }

}

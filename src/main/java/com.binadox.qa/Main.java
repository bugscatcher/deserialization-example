package com.binadox.qa;

import com.binadox.qa.dto.AbstractClass;
import com.binadox.qa.dto.SomeBeautifulClass;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(AbstractClass.class, new AbstractClassDeserializaer());
        mapper.registerModule(module);

        String json;
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/data.json")))) {
            json = buffer.lines().collect(Collectors.joining());
        }


        SomeBeautifulClass[] classes = mapper.readValue(json, SomeBeautifulClass[].class);
        System.out.println();
    }
}

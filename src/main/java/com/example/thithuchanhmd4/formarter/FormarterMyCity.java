package com.example.thithuchanhmd4.formarter;

import com.example.thithuchanhmd4.model.Nation;
import com.example.thithuchanhmd4.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class FormarterMyCity implements Formatter<Nation> {

    @Autowired
    private NationService nationService;

    @Override
    public Nation parse(String text, Locale locale) throws ParseException {
        return nationService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Nation object, Locale locale) {
        return null;
    }
}

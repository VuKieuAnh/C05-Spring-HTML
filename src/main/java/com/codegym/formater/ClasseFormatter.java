package com.codegym.formater;

import com.codegym.model.Classes;
import com.codegym.service.classes.IClassesService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@Component
public class ClasseFormatter implements Formatter<Classes> {
    private IClassesService classesService;

    public ClasseFormatter(IClassesService classesService) {
        this.classesService = classesService;
    }

    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        Classes classes = classesService.findById(Integer.parseInt(text));
        return classes;
    }

    @Override
    public String print(Classes object, Locale locale) {
        return null;
    }
}

package by.tc.task01.dao.impl;

import by.tc.task01.dao.Constant;
import by.tc.task01.dao.parsers.Util;
import by.tc.task01.dao.parsers.VacuumCleanerParser;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.Converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

    private Criteria criteria;
    private Set<Pattern> patterns;
    private static BufferedReader fileReader;

    static {
        try {
            fileReader = new BufferedReader(new FileReader("src/main/resources/appliances_db.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Appliance findNext() throws IOException {

        int counter = -1;
        String line;
        Matcher matcher;
        boolean isLineMatching;
        while ((line = fileReader.readLine()) != null) {

            isLineMatching = true;
            for (Pattern pattern : patterns) {
                matcher = pattern.matcher(line);
                if (!matcher.find()) {
                    isLineMatching = false;
                    break;
                }
            }

            if (isLineMatching) {
                return getAppliance(line);
            }
        }
        return null;
    }

    private Appliance getAppliance(String line) throws IOException {
        Class<?> applianceClass = Util.getApplianceClass(line);
        line = Util.trimApplianceClassData(line);
        if (applianceClass.equals(VacuumCleaner.class)) {
            return VacuumCleanerParser.parse(line);
        }

        throw new IOException("Wrong Class Name");
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
        this.patterns = Util.criteriaToPatterns(criteria);
    }
}

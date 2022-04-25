package by.tc.task01.dao.parsers;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.dao.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static by.tc.task01.entity.appliance.constant.Constant.allApplianceClasses;

public class Util {

    public static Map<Class<? extends Appliance>, String> getAppliances(String line) {
        Map<Class<? extends Appliance>, String> components = new HashMap<>();
        String className = "";
        int forClassNameSearch;
        int openParenthesesIndex = 0;
        int closeParenthesesIndex = 0;
        int numberOfOpenParentheses = 0;
        while ((openParenthesesIndex = line.indexOf(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD, closeParenthesesIndex)) != -1) {
            numberOfOpenParentheses = 1;
            closeParenthesesIndex = openParenthesesIndex + 1;
            while (numberOfOpenParentheses != 0) {
                switch (line.charAt(closeParenthesesIndex)) {
                    case (Constant.STRING_DATABASE_CLOSE_COMPONENT_FIELD) -> {
                        numberOfOpenParentheses--;
                    }
                    case (Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD) -> {
                        numberOfOpenParentheses++;
                    }

                }
                closeParenthesesIndex++;


            }
            className = line.substring(0, openParenthesesIndex);
            forClassNameSearch = className.lastIndexOf(Constant.STRING_DATABASE_DIVIDER);
            if (forClassNameSearch == -1) {
                forClassNameSearch = 0;
            } else {
                forClassNameSearch += Constant.STRING_DATABASE_DIVIDER.length();
            }
            className = className.substring(forClassNameSearch);
            components.put((Class<? extends Appliance>) getClassByItsFullName(className), line.substring(openParenthesesIndex + 1, closeParenthesesIndex-1));
        }
        return components;
    }

    public static Map<String, String> getParameters(String line) {
        Map<String, String> parameters = new HashMap<>();
        String[] parameterAndValue;
        String[] elements = line.split(Constant.STRING_DATABASE_DIVIDER);
        int numberOfOpenParentheses = 0;
        for (String element : elements) {
            if (!element.contains(String.valueOf(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD)) && numberOfOpenParentheses == 0) {
                parameterAndValue = element.split(Constant.STRING_DATABASE_EQUALS);
                parameters.put(parameterAndValue[0], parameterAndValue[1]);
            }
            else if (element.contains(String.valueOf(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD))) {
                numberOfOpenParentheses += 1;
            }
            if (element.contains(String.valueOf(Constant.STRING_DATABASE_CLOSE_COMPONENT_FIELD))) {
                numberOfOpenParentheses -= 1;
            }
        }
        return parameters;
    }

    public static Class<?> getApplianceClass(String line) {
        return getClassByItsFullName(line.substring(0, line.indexOf(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD)));
    }

    public static String trimApplianceClassData(String line) {
        return line.substring(line.indexOf(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD) + 1, line.lastIndexOf(Constant.STRING_DATABASE_CLOSE_COMPONENT_FIELD));
    }

    public static Set<Pattern> criteriaToPatterns(Criteria criteria) {

        return criteria.getCriteriaMap().entrySet()
                .stream()
                .map((entry) ->
                {
                    return Pattern.compile(fullNameApplianceClass(criteria.getClassToFind()) + "\\[[^\\]]*" + criteriaParameterAndValueToDataBaseString(entry.getKey(), entry.getValue()));
                })
                .collect(Collectors.toSet());
    }

    public static String criteriaParameterAndValueToDataBaseString(Enum<?> key, List<Object> value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(key)
                .append(Constant.STRING_DATABASE_EQUALS)
                .append("(");
        for (Object val : value) {
            stringBuilder.append(val.toString()).append("|");
        }
        stringBuilder
                .append(")")
                .append(Constant.STRING_DATABASE_DIVIDER);


        return stringBuilder.toString();
    }

    public static String applianceToDataBaseString(Appliance appliance) {

        StringBuilder applianceStringBuilder = new StringBuilder();

        String fullClassName = fullNameApplianceClass(appliance.getClass());

        Map<Enum<?>, Object> parameters = appliance.getAllParameters();

        String parametersString =
                parameters.entrySet()
                        .stream()
                        .map((entry) -> applianceParameterAndValueToDataBaseString(entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining(Constant.STRING_DATABASE_DIVIDER));

        Map<Enum<?>, Appliance> components = appliance.getAllComponents();
        String componentsString = components.values()
                .stream()
                .map(Util::applianceToDataBaseString)
                .collect(Collectors.joining(Constant.STRING_DATABASE_DIVIDER));

        if (components.size() == 0) {
            applianceStringBuilder
                    .append(fullClassName)
                    .append(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD)
                    .append(parametersString)
                    .append(Constant.STRING_DATABASE_CLOSE_COMPONENT_FIELD);

            return applianceStringBuilder.toString();
        }

        if (parameters.size() == 0) {
            applianceStringBuilder
                    .append(fullClassName)
                    .append(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD)
                    .append(componentsString)
                    .append(Constant.STRING_DATABASE_CLOSE_COMPONENT_FIELD);

            return applianceStringBuilder.toString();
        }

        applianceStringBuilder
                .append(fullClassName)
                .append(Constant.STRING_DATABASE_OPEN_COMPONENT_FIELD)
                .append(parametersString)
                .append(Constant.STRING_DATABASE_DIVIDER)
                .append(componentsString)
                .append(Constant.STRING_DATABASE_CLOSE_COMPONENT_FIELD);

        return applianceStringBuilder.toString();
    }

    public static String fullNameApplianceClass(Class<? extends Appliance> applianceClass) {
        StringBuilder fullClassName = new StringBuilder();
        fullClassName.append(applianceClass.getSimpleName());
        Class<?> superClass = applianceClass;
        while ((superClass = superClass.getSuperclass()) != Appliance.class) {
            fullClassName.insert(0, superClass.getSimpleName() + ".");
        }
        return fullClassName.toString();
    }

    public static String applianceParameterAndValueToDataBaseString(Enum<?> parameter, Object value) {
        return parameter.toString() + Constant.STRING_DATABASE_EQUALS + value.toString();
    }

    public static Class<?> getClassByItsFullName(String name) {
        for (Class<?> oneClass : allApplianceClasses) {
            if (name.equals(fullNameApplianceClass((Class<? extends Appliance>) oneClass))) {
                return oneClass;
            }
        }
        return null;
    }
}

package by.tc.task01.dao.parsers;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.components.Container;
import by.tc.task01.entity.appliance.components.measure.Measure;

import java.util.Map;

public class ContainerParser {

    public static Container parse(String containerString) {
        Map<String, String> parameters = Util.getParameters(containerString);

        return Container.getNewBuilder()
                .setName(ApplianceParser.parseName(parameters.get(Parameters.Appliance.NAME.toString())))
                .setManufacturer(ApplianceParser.parseManufacturer(parameters.get(Parameters.Appliance.MANUFACTURER.toString())))
                .setManufactureDate(ApplianceParser.parseDate(parameters.get(Parameters.Appliance.MANUFACTURE_DATE.toString())))
                .setCountry(ApplianceParser.parseCountry(parameters.get(Parameters.Appliance.COUNTRY.toString())))
                .setVolume(parseVolume(parameters.get(Parameters.Container.VOLUME.toString())), Measure.Volume.METERS_3)
                .build();
    }

    public static double parseVolume(String stringVolume) {
        return Double.parseDouble(stringVolume);
    }
}

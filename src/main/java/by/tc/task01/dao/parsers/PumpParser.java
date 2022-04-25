package by.tc.task01.dao.parsers;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.components.Pump;
import by.tc.task01.entity.appliance.components.measure.Measure;

import java.util.Map;

public class PumpParser {

    public static Pump parse(String pumpString) {
        Map<String, String> parameters = Util.getParameters(pumpString);

        return Pump.getNewBuilder()
                .setName(ApplianceParser.parseName(parameters.get(Parameters.Appliance.NAME.toString())))
                .setManufacturer(ApplianceParser.parseManufacturer(parameters.get(Parameters.Appliance.MANUFACTURER.toString())))
                .setManufactureDate(ApplianceParser.parseDate(parameters.get(Parameters.Appliance.MANUFACTURE_DATE.toString())))
                .setCountry(ApplianceParser.parseCountry(parameters.get(Parameters.Appliance.COUNTRY.toString())))
                .setPower(parsePower(parameters.get(Parameters.Pump.POWER.toString())), Measure.Power.WATT)
                .build();
    }

    public static double parsePower(String stringPower) {
        return Double.parseDouble(stringPower);
    }
}

package by.tc.task01.dao.parsers;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.components.Battery;
import by.tc.task01.entity.appliance.components.measure.Measure;

import java.util.Map;

public class BatteryParser {

    public static Battery parse(String stringBattery) {
        Map<String, String> parameters = Util.getParameters(stringBattery);

        return Battery.getBuilder()
                .setName(ApplianceParser.parseName(parameters.get(Parameters.Appliance.NAME.toString())))
                .setManufacturer(ApplianceParser.parseManufacturer(parameters.get(Parameters.Appliance.MANUFACTURER.toString())))
                .setManufactureDate(ApplianceParser.parseDate(parameters.get(Parameters.Appliance.MANUFACTURE_DATE.toString())))
                .setCountry(ApplianceParser.parseCountry(parameters.get(Parameters.Appliance.COUNTRY.toString())))
                .setType(parseType(parameters.get(Parameters.Battery.TYPE.toString())))
                .setCapacity(parseCapacity(parameters.get(Parameters.Battery.CAPACITY.toString())), Measure.BatteryCapacity.AMPER_HOUR)
                .build();

    }

    public static by.tc.task01.entity.appliance.constant.Constant.BatteryType parseType(String stringType) {
        return by.tc.task01.entity.appliance.constant.Constant.BatteryType.valueOf(stringType);
    }

    public static double parseCapacity(String stringCapacity) {
        return  Double.parseDouble(stringCapacity);
    }

}

package by.tc.task01.dao.parsers;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.VacuumCleaner;
import by.tc.task01.entity.appliance.components.Battery;
import by.tc.task01.entity.appliance.components.Container;
import by.tc.task01.entity.appliance.components.Pump;

import java.util.Map;

public class VacuumCleanerParser {

    public static VacuumCleaner parse(String vacuumCleanerString) {



        Map<String, String> parameters = Util.getParameters(vacuumCleanerString);
        Map<Class<? extends Appliance>, String> components = Util.getAppliances(vacuumCleanerString);

        Battery battery = BatteryParser.parse(components.get(Battery.class));

        Container container = ContainerParser.parse(components.get(Container.class));

        Pump pump = PumpParser.parse(components.get(Pump.class));


        return VacuumCleaner.getBuilder()
                .setName(ApplianceParser.parseName(parameters.get(Parameters.Appliance.NAME.toString())))
                .setManufacturer(ApplianceParser.parseManufacturer(parameters.get(Parameters.Appliance.MANUFACTURER.toString())))
                .setManufactureDate(ApplianceParser.parseDate(parameters.get(Parameters.Appliance.MANUFACTURE_DATE.toString())))
                .setCountry(ApplianceParser.parseCountry(parameters.get(Parameters.Appliance.COUNTRY.toString())))
                .setBattery(battery)
                .setContainer(container)
                .setPump(pump)
                .build();
    }

}

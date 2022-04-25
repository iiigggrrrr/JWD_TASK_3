package by.tc.task01.entity.appliance.constant;


import by.tc.task01.entity.appliance.Laptop;
import by.tc.task01.entity.appliance.VacuumCleaner;
import by.tc.task01.entity.appliance.components.Battery;
import by.tc.task01.entity.appliance.components.Container;
import by.tc.task01.entity.appliance.components.Display;
import by.tc.task01.entity.appliance.components.Pump;

public final class Constant {
    public static enum Manufacturer {
        APPLE, AERUS, BOSCH;
    }

    public static enum Country {
        USA, VIETNAM, CHINA, UZBEKISTAN;
    }

    public static enum ComputerOS {
        WINDOWS, LINUX, MAC_OS;
    }

    public static enum BatteryType {
        LI_POL, LI_ION, NI_CL, LI_COL;
    }

    public static final Class[] allApplianceClasses = {
            Battery.class, VacuumCleaner.class, Battery.class, Container.class, Pump.class, Display.class, Laptop.class
    };
}

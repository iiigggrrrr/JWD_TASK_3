package by.tc.task01.entity.appliance.components.measure;


import by.tc.task01.util.UnitOfPhysicalQuantity;

public class Measure {

    public static enum Volume implements UnitOfPhysicalQuantity {
        MILLIMETERS_3(1D/1_000_000_000), METERS_3(1);

        private final double proportionalityFactor;

        Volume(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }

        @Override
        public double getProportionalityFactor() {
            return this.proportionalityFactor;
        }
    }

    public static enum BatteryCapacity implements UnitOfPhysicalQuantity{
        AMPER_HOUR(1);

        private final double proportionalityFactor;

        BatteryCapacity(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }

        @Override
        public double getProportionalityFactor() {
            return this.proportionalityFactor;
        }
    }

    public static enum LinearSize implements UnitOfPhysicalQuantity{
        MILLIMETERS(1D/1_000), INCHES(1D/39.730), METERS(1);

        private final double proportionalityFactor;

        LinearSize(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }

        @Override
        public double getProportionalityFactor() {
            return this.proportionalityFactor;
        }
    }

    public static enum Power implements UnitOfPhysicalQuantity{
        WATT(1);

        private final double proportionalityFactor;

        Power(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }

        @Override
        public double getProportionalityFactor() {
            return this.proportionalityFactor;
        }
    }

    public static enum Weight implements UnitOfPhysicalQuantity {
        MILLIGRAM(1D/1_000), GRAM(1), KILOGRAM(1_000), TONN(1_000_000);

        private final double proportionalityFactor;

        Weight(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }

        @Override
        public double getProportionalityFactor() {
            return proportionalityFactor;
        }
    }

    public static enum Information implements UnitOfPhysicalQuantity {

        BYTE(1D/1_000), MEGABYTE(1), GIGABYTE(1_000), TERABYTE(1_000_000);

        private final double proportionalityFactor;

        Information(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }
        @Override
        public double getProportionalityFactor() {
            return proportionalityFactor;
        }
    }

    public static enum Frequency implements UnitOfPhysicalQuantity {

        HZ(1D/1_000), MEGA_HZ(1), GIGA_HZ(1_000);

        private final double proportionalityFactor;

        Frequency(double proportionalityFactor) {
            this.proportionalityFactor = proportionalityFactor;
        }
        @Override
        public double getProportionalityFactor() {
            return proportionalityFactor;
        }
    }
}

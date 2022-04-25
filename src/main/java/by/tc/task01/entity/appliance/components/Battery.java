package by.tc.task01.entity.appliance.components;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.components.measure.Measure;
import by.tc.task01.entity.appliance.constant.Constant;

import java.util.HashMap;
import java.util.Map;


public class Battery extends Component {

    public Battery() {
        for (Parameters.Battery parameter : Parameters.Battery.values()) {
            parameters.put(parameter, null);
        }
    }

    public double getCapacity() {
        return (double) parameters.get(Parameters.Battery.CAPACITY);
    }

    public Constant.BatteryType getType() {
        return (Constant.BatteryType) parameters.get(Parameters.Battery.TYPE);
    }

    public void setCapacity(double capacity) {
        parameters.replace(Parameters.Battery.CAPACITY, capacity);
    }

    public void setType(Constant.BatteryType type) {
        parameters.replace(Parameters.Battery.TYPE, type);
    }

    public static Builder getBuilder() {
        return new Builder(new Battery());
    }



    public static class Builder extends Appliance.Builder<Battery, Builder> {

        protected Builder(Battery child) {
            super(child);
            injectReturnBuilder(this);
        }

        public Builder setType(Constant.BatteryType type) {
            getNewProduct().setType(type);
            return self();
        }

        public Builder setCapacity(double value, Measure.BatteryCapacity unit) {
            getNewProduct().setCapacity(value * unit.getProportionalityFactor());
            return self();
        }
    }
}

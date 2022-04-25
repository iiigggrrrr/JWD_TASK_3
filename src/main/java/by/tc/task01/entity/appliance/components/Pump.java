package by.tc.task01.entity.appliance.components;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.components.measure.Measure;


public final class Pump extends Component {

    private Pump() {
        parameters.put(Parameters.Pump.POWER, 0);
    }

    private void setPower(double power, Measure.Power unit) {
        parameters.replace(Parameters.Pump.POWER, power * unit.getProportionalityFactor());
    }

    public static Builder getNewBuilder() {
        return new Builder(new Pump());
    }

    @Override
    public String toString() {
        return "PUMP_POWER=" + parameters.get(Parameters.Pump.POWER);
    }

    public static class Builder extends Appliance.Builder<Pump, Builder> {

        protected Builder(Pump child) {
            super(child);
            injectReturnBuilder(this);
        }

        public Builder setPower(double value, Measure.Power units) {
            getNewProduct().setPower(value, units);
            return self();
        }
    }
}

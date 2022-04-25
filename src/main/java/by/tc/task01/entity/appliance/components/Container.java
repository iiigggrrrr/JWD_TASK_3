package by.tc.task01.entity.appliance.components;


import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.components.measure.Measure;


public final class Container extends Component {

    private Container() {
        parameters.put(Parameters.Container.VOLUME, null);
    }

    private void setVolume(double volume, Measure.Volume unit) {
        parameters.replace(Parameters.Container.VOLUME, volume * unit.getProportionalityFactor());
    }

    public double getVolume() {
        return (double) parameters.get(Parameters.Container.VOLUME);
    }

    public static Builder getNewBuilder() {
        return new Builder(new Container());
    }

    @Override
    public String toString() {
        return "CONTAINER_VOLUME=" + parameters.get(Parameters.Container.VOLUME);
    }


    public static class Builder extends Appliance.Builder<Container, Builder> {

        protected Builder(Container child) {
            super(child);
            injectReturnBuilder(this);
        }

        public Builder setVolume(double value, Measure.Volume unit) {
            getNewProduct().setVolume(value, unit);
            return self();
        }

    }
}

package by.tc.task01.entity.appliance.components;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.components.measure.Measure;


public class Display extends Component {

    private Display() {
        parameters.put(Parameters.Display.DIAGONAL, 0);
        parameters.put(Parameters.Display.XY_NUMBER_OF_PIXELS, new int[]{0, 0});
    }

    public int[] getXyNumberOfPixels() {
        return (int[]) parameters.get(Parameters.Display.XY_NUMBER_OF_PIXELS);
    }

    public double getDiagonal() {
        return (double) parameters.get(Parameters.Display.DIAGONAL);
    }

    private void setDiagonal(double diagonal, Measure.LinearSize unit) {
        parameters.replace(Parameters.Display.DIAGONAL, diagonal * unit.getProportionalityFactor());
    }

    private void setXyNumberOfPixels(int x, int y) {
        parameters.replace(Parameters.Display.XY_NUMBER_OF_PIXELS, new int[] {x, y});
    }


    public static class Builder extends Appliance.Builder<Display, Display.Builder> {

        protected Builder(Display child) {
            super(child);
            injectReturnBuilder(this);
        }

        public Display.Builder setDiagonal(double value, Measure.LinearSize unit) {
            getNewProduct().setDiagonal(value, unit);
            return self();
        }

        public Display.Builder setXyNumberOfPixels(int x, int y) {
            getNewProduct().setXyNumberOfPixels(x, y);
            return self();
        }
    }
}

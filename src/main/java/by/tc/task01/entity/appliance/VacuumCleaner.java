package by.tc.task01.entity.appliance;

import by.tc.task01.entity.Components;
import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.components.Battery;
import by.tc.task01.entity.appliance.components.Container;
import by.tc.task01.entity.appliance.components.Pump;


public final class VacuumCleaner extends Appliance {

    private VacuumCleaner() {

        for (Parameters.VacuumCleaner parameter : Parameters.VacuumCleaner.values()) {
            parameters.put(parameter, null);
        }

        for (Components.VacuumCleaner component : Components.VacuumCleaner.values()) {
            components.put(component, null);
        }
    }

    public Battery getBattery() {
        return (Battery) components.get(Components.VacuumCleaner.BATTERY);
    }

    public void setBattery(Battery battery) {
        components.replace(Components.VacuumCleaner.BATTERY, battery);
    }

    public Container getContainer() {
        return (Container) components.get(Components.VacuumCleaner.CONTAINER);
    }

    public void setContainer(Container container) {
        components.replace(Components.VacuumCleaner.CONTAINER, container);
    }

    public Pump getPump() {
        return (Pump) components.get(Components.VacuumCleaner.PUMP);
    }

    public void setPump(Pump pump) {
        components.replace(Components.VacuumCleaner.PUMP, pump);
    }

    public static Builder getBuilder() {
        return new Builder(new VacuumCleaner());
    }

    public static class Builder extends Appliance.Builder<VacuumCleaner, Builder>{

       protected Builder(VacuumCleaner child) {
           super(child);
           injectReturnBuilder(this);
       }

       public Builder setBattery(Battery battery) {
           getNewProduct().setBattery(battery);
           return this;
       }

       public Builder setContainer(Container container) {
           getNewProduct().setContainer(container);
           return this;
       }

       public Builder setPump(Pump pump) {
           getNewProduct().setPump(pump);
           return this;
       }

       @Override
       public String toString() {
           return super.toString() ;
       }
   }

}



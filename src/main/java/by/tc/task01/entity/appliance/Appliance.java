package by.tc.task01.entity.appliance;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.builder.BuilderImpl;
import by.tc.task01.entity.appliance.constant.Constant;
import by.tc.task01.service.validation.Validator;
import by.tc.task01.util.Date;

import java.util.HashMap;
import java.util.Map;


public abstract class Appliance {

    protected final Map<Enum<?>, Object> parameters;
    protected final Map<Enum<?>, Appliance> components;

    protected Appliance() {
        parameters = new HashMap<>();
        for (Parameters.Appliance parameter : Parameters.Appliance.values()) {
            parameters.put(parameter, null);
        }
        components = new HashMap<>();
    }

    public Map<Enum<?>, Object> getAllParameters() {
        return parameters;
    }

    public Map<Enum<?>, Appliance> getAllComponents() {
        return components;
    }

    void setCountry(Constant.Country country) {
        parameters.replace(Parameters.Appliance.COUNTRY, country);
    }

    void setManufacturer(Constant.Manufacturer manufacturer) {
        parameters.replace(Parameters.Appliance.MANUFACTURER, manufacturer);
    }

    void setName(String name) {
        parameters.replace(Parameters.Appliance.NAME, name);
    }

    void setManufactureDate(Date date) {
        parameters.replace(Parameters.Appliance.MANUFACTURE_DATE, date);
    }

    public Constant.Country getCountry() {
        return (Constant.Country) parameters.get(Parameters.Appliance.COUNTRY);
    }

    public Constant.Manufacturer getManufacturer() {
        return (Constant.Manufacturer) parameters.get(Parameters.Appliance.MANUFACTURER);
    }

    public String getName() {
        return (String) parameters.get(Parameters.Appliance.NAME);
    }

    public Date getManufactureDate() {
        return (Date) parameters.get(Parameters.Appliance.MANUFACTURE_DATE);
    }

    protected static class Builder<T extends Appliance, RetBuilder extends Builder<?, ?>> extends BuilderImpl<T, RetBuilder> {

        protected Builder(T child) {
            super(child);
        }

        @Override
        protected boolean validator() {
            return Validator.applianceValidator(getNewProduct());
        }

        public RetBuilder setName(String newName) {
            getNewProduct().setName(newName);
            return self();
        }

        public RetBuilder setCountry(Constant.Country country) {
            getNewProduct().setCountry(country);
            return self();
        }

        public RetBuilder setManufacturer(Constant.Manufacturer manufacturer) {
            getNewProduct().setManufacturer(manufacturer);
            return self();
        }

        public RetBuilder setManufactureDate(Date date) {
            getNewProduct().setManufactureDate(date);
            return self();
        }
    }

}




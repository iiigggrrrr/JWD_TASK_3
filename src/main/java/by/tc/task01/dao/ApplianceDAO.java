package by.tc.task01.dao;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceDAO {
	Appliance findNext() throws IOException;

	void addAppliance(Appliance appliance) throws IOException;

	void setCriteria(Criteria criteria);
}

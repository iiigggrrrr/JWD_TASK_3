package by.tc.task01.service;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceService {	
	
	Appliance findNext() throws IOException;

	boolean setCriteria(Criteria criteria);

	void resetCriteriaSearching();

	void addAppliance(Appliance appliance) throws IOException;
}

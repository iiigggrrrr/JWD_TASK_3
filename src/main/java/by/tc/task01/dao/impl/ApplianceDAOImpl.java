package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import java.io.IOException;


public class ApplianceDAOImpl implements ApplianceDAO{

	private int lastApplianceNumber;
	private Finder finder;
	private Setter setter;

	public ApplianceDAOImpl() throws IOException {
		finder = new Finder();
		setter = new Setter();
	}


	@Override
	public void setCriteria(Criteria criteria) {
		finder.setCriteria(criteria);
	}

	@Override
	public Appliance findNext() throws IOException {
		return finder.findNext();
	}

	@Override
	public void addAppliance(Appliance appliance) throws IOException {
		setter.set(appliance);
	}

}

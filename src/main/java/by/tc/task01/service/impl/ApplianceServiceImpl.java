package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.io.IOException;

public class ApplianceServiceImpl implements ApplianceService{

	private final ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();

	@Override
	public Appliance findNext() throws IOException {

		return applianceDAO.findNext();
	}

	@Override
	public boolean setCriteria(Criteria criteria) {

		if (!Validator.criteriaValidator(criteria)) {
			return false;
		}

		applianceDAO.setCriteria(criteria);

		return true;
	}

	@Override
	public void resetCriteriaSearching() {

	}

	@Override
	public void addAppliance(Appliance appliance) throws IOException {
		applianceDAO.addAppliance(appliance);
	}
}

//you may add your own new classes

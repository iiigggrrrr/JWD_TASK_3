package by.tc.task01.service.validation;

import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {

		return !criteria.getCriteriaMap().containsValue(null);

	}

	public static boolean applianceValidator(Appliance appliance) {

		return !appliance.getAllParameters().containsValue(null);

	}

}

//you may add your own new classes
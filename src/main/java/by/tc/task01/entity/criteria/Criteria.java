package by.tc.task01.entity.criteria;

import by.tc.task01.entity.appliance.Appliance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Criteria {
	private final Class<? extends Appliance> classToFind;
	private final Map<Enum<?>, List<Object>> criteriaMap;


	public Criteria(Class<? extends Appliance> classToFind) {

		this.classToFind = classToFind;
		criteriaMap = new HashMap<>();

	}

	public Map<? extends Enum<?>, List<Object>> getCriteriaMap() {
		return criteriaMap;
	}


	public Criteria add(Enum<?> parameter, Object value) {

		if (!criteriaMap.containsKey(parameter)) {
			criteriaMap.put(parameter, new ArrayList<>());
		}
		criteriaMap.get(parameter).add(value);
		return this;

	}

	public Class<? extends Appliance> getClassToFind() {
		return classToFind;
	}

	@Override
	public String toString() {
		return "Criteria{" +
				"criteriaMap=" + criteriaMap.toString() +
				'}';
	}
}

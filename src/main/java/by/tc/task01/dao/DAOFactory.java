package by.tc.task01.dao;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

import java.io.IOException;

public final class DAOFactory {
	private static DAOFactory instance;

	static {
		try {
			instance = new DAOFactory();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory() throws IOException {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}

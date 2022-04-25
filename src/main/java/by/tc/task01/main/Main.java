package by.tc.task01.main;

import by.tc.task01.entity.Parameters;
import by.tc.task01.entity.appliance.Appliance;
import by.tc.task01.entity.appliance.VacuumCleaner;
import by.tc.task01.entity.appliance.components.Battery;
import by.tc.task01.entity.appliance.components.Container;
import by.tc.task01.entity.appliance.components.Pump;
import by.tc.task01.entity.appliance.constant.Constant;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.entity.appliance.components.measure.Measure.*;
import by.tc.task01.service.impl.ApplianceServiceImpl;
import by.tc.task01.util.Date;

import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////


		VacuumCleaner vc = VacuumCleaner.getBuilder()

				.setName("VacuumCleaner225")
				.setCountry(Constant.Country.CHINA)
				.setManufactureDate(new Date("21/10/2002"))
				.setManufacturer(Constant.Manufacturer.AERUS)

				.setBattery(
						Battery.getBuilder()
								.setName("B_XXX")
								.setCountry(Constant.Country.CHINA)
								.setManufactureDate(new Date("21/10/2002"))
								.setManufacturer(Constant.Manufacturer.AERUS)
								.setType(Constant.BatteryType.LI_ION)
								.setCapacity(10, BatteryCapacity.AMPER_HOUR)
								.build())
				.setPump(
						Pump.getNewBuilder()
								.setName("P_XXX")
								.setCountry(Constant.Country.CHINA)
								.setManufactureDate(new Date("21/10/2002"))
								.setManufacturer(Constant.Manufacturer.AERUS)
								.setPower(100, Power.WATT)
								.build())
				.setContainer(
						Container.getNewBuilder()
								.setName("C_XXX")
								.setCountry(Constant.Country.CHINA)
								.setManufactureDate(new Date("21/10/2002"))
								.setManufacturer(Constant.Manufacturer.AERUS)
								.setVolume(100, Volume.METERS_3)
								.build())
				.build();


		Criteria criteria = new Criteria(VacuumCleaner.class);
		criteria.add(Parameters.Appliance.NAME, "VacuumCleaner224")
				.add(Parameters.Appliance.NAME, "VacuumCleaner225")
				.add(Parameters.Appliance.COUNTRY, Constant.Country.CHINA);



		ApplianceService applianceService = new ApplianceServiceImpl();
		try {
			applianceService.setCriteria(criteria);

			System.out.println(applianceService.findNext().getAllParameters().toString());


		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}

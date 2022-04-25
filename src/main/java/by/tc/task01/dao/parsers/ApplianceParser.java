package by.tc.task01.dao.parsers;

import by.tc.task01.entity.appliance.constant.Constant;
import by.tc.task01.util.Date;


public class ApplianceParser {

   public static String parseName(String stringName) {
       return stringName;
   }

   public static Constant.Country parseCountry(String stringCountry) {
       return by.tc.task01.entity.appliance.constant.Constant.Country.valueOf(stringCountry);
   }

   public static Date parseDate(String stringDate) {
       return new Date(stringDate);
   }

   public static Constant.Manufacturer parseManufacturer(String stringManufacturer) {
       return by.tc.task01.entity.appliance.constant.Constant.Manufacturer.valueOf(stringManufacturer);
   }
}

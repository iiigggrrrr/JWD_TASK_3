package by.tc.task01.dao.impl;

import by.tc.task01.dao.Constant;
import by.tc.task01.dao.parsers.Util;
import by.tc.task01.entity.appliance.Appliance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Setter {
    private BufferedWriter bufferWriter;

    public void set(Appliance appliance) throws IOException {

        String applianceString = Util.applianceToDataBaseString(appliance);
        bufferWriter = new BufferedWriter(new FileWriter(Constant.FILE_PATH, true));
        bufferWriter.write(applianceString + "\n");
        bufferWriter.close();
    }
}

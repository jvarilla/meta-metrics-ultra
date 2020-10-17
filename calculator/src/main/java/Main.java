import classloading.ClassManager;
import dit.DitCalculator;
import dit.DitCalculatorImpl;
import dto.classsummary.dit.DitMetricsDto;
import dto.classsummary.wmc.WmcMetricsDto;
import wmc.WmcCalculator;
import wmc.WmcCalculatorImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        ClassManager classManager = new ClassManager();
        classManager.execute();
    }

    public static Class getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

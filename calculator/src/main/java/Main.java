import dit.DitCalculator;
import dit.DitCalculatorImpl;
import dto.classsummary.dit.DitMetricsDto;
import dto.classsummary.wmc.WmcMetricsDto;
import wmc.WmcCalculator;
import wmc.WmcCalculatorImpl;

public class Main {
    public static void main(String[] args) {
        WmcCalculator wmcCalculator = new WmcCalculatorImpl();
        WmcMetricsDto wmcMetricsDto = wmcCalculator.calculate(WmcCalculatorImpl.class);
        System.out.println("Wmc metrics:");
        System.out.println(wmcMetricsDto);
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

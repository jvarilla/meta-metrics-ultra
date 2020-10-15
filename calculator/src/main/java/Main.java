import dit.DitCalculator;
import dit.DitCalculatorImpl;
import dto.classsummary.dit.DitMetricsDto;

public class Main {
    public static void main(String[] args) {
//        IWmcCalculator wmcCalculator = new WmcCalculator();
        DitCalculator ditCalcuator = new DitCalculatorImpl();
//        Class testClass = getClass("inlincompiler.InlineCompiler");
        Class grandChildClass = getClass("testclasses.GrandChildOne");
//        double wmc = wmcCalculator.calculateMetric(testClass);
        DitMetricsDto ditMetricsDto = ditCalcuator.calculate(grandChildClass);
//        System.out.println("Wmc: " + wmc);
        System.out.println("Dit of grandChild: " + ditMetricsDto.getAncestors().toString());
        System.out.println("Dit of grandChild: " + ditMetricsDto.getValue());
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

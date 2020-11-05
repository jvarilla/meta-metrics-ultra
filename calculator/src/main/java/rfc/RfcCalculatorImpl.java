package rfc;

import dit.DitCalculator;
import dit.DitCalculatorImpl;

import java.util.Arrays;

public class RfcCalculatorImpl implements RfcCalculator {
    private int total;
    private int numberOfMethodsFromCurrentClass;
    private int numberOfMethodsFromFieldObjects;
    private int numberOfFieldObjects;
    private DitCalculator ditCalculator;

    public RfcCalculatorImpl() {
        ditCalculator = new DitCalculatorImpl();
    }

    @Override
    public RfcMetricsDto calculate(Class<?> theClass) {
        RfcMetricsDto rfcMetricsDto = new RfcMetricsDto();

        int numFieldsThatAreObjects = (int) Arrays.stream(theClass.getDeclaredFields()).filter(field -> {
            Class<?> c = field.getClass();
            return !(c.equals(String.class)
                    || c.equals(String[].class)
                    || c.isArray() && c.getComponentType().isPrimitive());
        }).count();

        int methodsFromFields = Arrays.stream(theClass.getFields()).map(field -> {
            return field.getClass().getDeclaredMethods().length;
        }).reduce(0, Integer::sum);

        int numMethodsFromCurrentClass = theClass.getDeclaredMethods().length;

        int numInheritedMethods = this.ditCalculator.calculate(theClass)
                .getAncestors().stream().map(ancestor -> {
                    try {
                        return Class.forName(ancestor).getDeclaredMethods().length;
                    } catch (Exception e) {
                        return 0;
                    }
                }).reduce(0, Integer::sum);


        rfcMetricsDto.setNumberOfFieldObjects(numFieldsThatAreObjects);
        rfcMetricsDto.setNumberOfMethodsFromCurrentClass(numMethodsFromCurrentClass);
        rfcMetricsDto.setNumberOfMethodsFromFieldObjects(methodsFromFields);
        rfcMetricsDto.setNumberOfInheritedMethods(numInheritedMethods);
        rfcMetricsDto.setTotal(numMethodsFromCurrentClass + methodsFromFields + numInheritedMethods);


        return rfcMetricsDto;
    }
}

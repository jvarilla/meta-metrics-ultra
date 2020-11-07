package rfc;

import dit.DitCalculator;
import dit.DitCalculatorImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

        List<Class<?>> fieldObjClasses = Arrays.stream(theClass.getDeclaredFields()).filter(field -> {
            Class<?> c = field.getType();
            return isAnObjectField(c);
        }).map(field -> field.getType()).collect(Collectors.toList());


        int numFieldsThatAreObjects = fieldObjClasses.size();
        int methodsFromFields = 0;

        for(Class<?> fieldObjClass : fieldObjClasses) {
            methodsFromFields += fieldObjClass.getDeclaredMethods().length;
        }

        int numMethodsFromCurrentClass = theClass.getDeclaredMethods().length;


        int numInheritedMethods = this.ditCalculator.getAncestors(theClass).stream()
                .map(ancestor -> {
                    try {
                        System.out.println("Ancestor: " + ancestor);
                        System.out.println("Class of ancestor: " + ancestor.getName());
                        return ancestor.getDeclaredMethods().length;
                    } catch (Exception e) {
                        return 0;
                    }
                }).reduce(0, Integer::sum);


        rfcMetricsDto.setNumberOfFieldObjects(numFieldsThatAreObjects);
        rfcMetricsDto.setMethodsFromCurrentClass(numMethodsFromCurrentClass);
        rfcMetricsDto.setMethodsFromFieldObjects(methodsFromFields);
        rfcMetricsDto.setMethodsInherited(numInheritedMethods);
        rfcMetricsDto.setTotal(numMethodsFromCurrentClass + methodsFromFields + numInheritedMethods);


        return rfcMetricsDto;
    }

    private boolean isAnObjectField(Class<?> clazz) {
        return !(clazz.isArray()
                && clazz.isPrimitive())
                && !(clazz.isPrimitive())
                && !(clazz.getName().trim().equals("[I"));
    }
}

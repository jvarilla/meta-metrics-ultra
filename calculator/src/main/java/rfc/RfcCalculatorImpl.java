package rfc;

import dit.DitCalculator;
import dit.DitCalculatorImpl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RfcCalculatorImpl implements RfcCalculator {
    private DitCalculator ditCalculator;

    public RfcCalculatorImpl() {
        ditCalculator = new DitCalculatorImpl();
    }

    @Override
    public RfcMetricsDto calculate(Class<?> clazz) {
        RfcMetricsDto rfcMetricsDto = new RfcMetricsDto();

        List<Class<?>> fieldObjClasses = Arrays.stream(clazz.getDeclaredFields()).filter(field -> {
            Class<?> c = field.getType();
            return isAnObjectField(c);
        }).map(Field::getType).collect(Collectors.toList());

        List<Class<?>> distinctFieldObjClasses = fieldObjClasses.stream()
                                                .distinct().collect(Collectors.toList());

        int numFieldsThatAreObjects = fieldObjClasses.size();
        int methodsFromFields = 0;

        for(Class<?> fieldObjClass : distinctFieldObjClasses) {
            methodsFromFields += fieldObjClass.getDeclaredMethods().length;
        }

        int numMethodsFromCurrentClass = clazz.getDeclaredMethods().length;


        int numInheritedMethods = this.ditCalculator.getAncestors(clazz).stream()
                .map(ancestor -> {
                    try {
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

package wmc;

import dto.classsummary.wmc.NumberOfMethodsDto;
import dto.classsummary.wmc.WmcMetricsDto;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class WmcCalculatorImpl implements WmcCalculator {
    private Predicate<Method> publicMethodsCondition;
    private Predicate<Method> protectedMethodsCondition;
    private Predicate<Method> privateMethodsCondition;
    private Predicate<Method> staticMethodsCondition;

    public WmcCalculatorImpl() {
        this.publicMethodsCondition = method -> Modifier.isPublic(method.getModifiers());
        this.protectedMethodsCondition = method -> Modifier.isProtected(method.getModifiers());
        this.privateMethodsCondition = method -> Modifier.isPrivate(method.getModifiers());
        this.staticMethodsCondition = method -> Modifier.isStatic(method.getModifiers());
    }
    @Override
    public WmcMetricsDto calculate(Class classToAnalyze) {
        WmcMetricsDto results = new WmcMetricsDto();

        results.setValue(getEligibleMethods(classToAnalyze).length + classToAnalyze.getConstructors().length);
        results.setNumberOfConstructors(classToAnalyze.getConstructors().length);
        results.setNumberOfMethods(calculateMethodsMetrics(classToAnalyze));

        return results;
    }

   public NumberOfMethodsDto calculateMethodsMetrics(Class classToAnalyze) {
        NumberOfMethodsDto numberOfMethodsDto = new NumberOfMethodsDto();
        numberOfMethodsDto.setTotalNumberOfMethods(getEligibleMethods(classToAnalyze).length);

        numberOfMethodsDto
                .setTotalPublicMethods(countNumMethodsWithCondition(classToAnalyze,publicMethodsCondition));

        numberOfMethodsDto
                .setTotalProtectedMethods(countNumMethodsWithCondition(classToAnalyze,protectedMethodsCondition));

        numberOfMethodsDto
                .setTotalPrivateMethods(countNumMethodsWithCondition(classToAnalyze,privateMethodsCondition));

        numberOfMethodsDto
                .setTotalStaticMethods(countNumMethodsWithCondition(classToAnalyze,staticMethodsCondition));

        return numberOfMethodsDto;

    }

    public int countNumMethodsWithCondition(Class theClass, Predicate<Method> condition) {
        return Arrays.stream(getEligibleMethods(theClass))
                .filter(condition).toArray().length;
    }

    public Method[] getEligibleMethods(Class theClass) {
        Predicate<Method> noLambdasFilter = method -> !method.getName().contains("lambda");
        return Arrays.stream(theClass.getDeclaredMethods()).filter(noLambdasFilter).toArray(Method[]::new);
    }
}

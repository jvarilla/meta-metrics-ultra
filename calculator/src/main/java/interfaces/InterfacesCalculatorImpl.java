package interfaces;

import dto.classsummary.interfaces.InterfacesMetricsDto;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterfacesCalculatorImpl implements InterfacesCalculator {
    @Override
    public InterfacesMetricsDto calculate(Class<?> theClass) {
        InterfacesMetricsDto interfacesMetricsDto = new InterfacesMetricsDto();
        List<Class<?>> interfacesImplemented = Arrays.asList(theClass.getInterfaces());
        interfacesMetricsDto.setInterfacesImplemented(
                Arrays.asList(
                        interfacesImplemented.stream()
                                .map(theInterface -> theInterface.getName())
                                .toArray(String[]::new)));

        interfacesMetricsDto.setNumberOfInterfacesImplemented(interfacesImplemented.size());

        return interfacesMetricsDto;
    }
}

package meta.metrics.interfaces;

import java.util.Arrays;
import java.util.List;

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

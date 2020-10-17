package interfaces;

import dto.classsummary.interfaces.InterfacesMetricsDto;

public interface InterfacesCalculator {
    InterfacesMetricsDto calculate(Class<?> theClass);
}

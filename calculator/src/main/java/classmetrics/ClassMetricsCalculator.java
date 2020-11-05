package classmetrics;

import dto.MetricsResultsDto;

import java.util.List;

public interface ClassMetricsCalculator {
    MetricsResultsDto calculate(List<Class<?>> clazzes);
}

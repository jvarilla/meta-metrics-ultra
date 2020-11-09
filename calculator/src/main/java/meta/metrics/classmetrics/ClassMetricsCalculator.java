package meta.metrics.classmetrics;

import meta.metrics.dto.MetricsResultsDto;

import java.util.List;

public interface ClassMetricsCalculator {
    MetricsResultsDto calculate(List<Class<?>> clazzes);
}

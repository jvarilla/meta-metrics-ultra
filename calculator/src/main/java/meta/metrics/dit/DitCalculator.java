package meta.metrics.dit;

import java.util.List;

public interface DitCalculator {
    DitMetricsDto calculate(Class<?> clazz);
    List<Class<?>> getAncestors(Class<?> clazz);
}

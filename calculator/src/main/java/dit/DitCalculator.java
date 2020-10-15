package dit;

import dto.classsummary.dit.DitMetricsDto;

public interface DitCalculator {
    DitMetricsDto calculate(Class classToAnalyze);
}

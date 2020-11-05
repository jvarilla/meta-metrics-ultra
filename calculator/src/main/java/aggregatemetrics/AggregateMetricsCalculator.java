package aggregatemetrics;

import dto.ClassSummaryDto;

import java.util.List;

public interface AggregateMetricsCalculator {
    SummaryDto calculate(List<ClassSummaryDto> clazzMetricSummaries);
}

package meta.metrics.aggregatemetrics;

import meta.metrics.dto.ClassSummaryDto;

import java.util.List;

public interface AggregateMetricsCalculator {
    SummaryDto calculate(List<ClassSummaryDto> clazzMetricSummaries);
}

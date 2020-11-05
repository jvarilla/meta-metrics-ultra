package aggregatemetrics;

import dto.classsummary.ClassSummaryDto;

import java.util.List;

public interface AggregateMetricsCalculator {
    SummaryDto calculate(List<ClassSummaryDto> clazzMetricSummaries);
}

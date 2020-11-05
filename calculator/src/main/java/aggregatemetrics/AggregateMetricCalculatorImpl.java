package aggregatemetrics;

import dto.classsummary.ClassSummaryDto;

import java.util.List;

public class AggregateMetricCalculatorImpl implements AggregateMetricsCalculator{
    @Override
    public SummaryDto calculate(List<ClassSummaryDto> clazzMetricSummaries) {
        SummaryDto summaryDto = new SummaryDto();
        int numberOfClasses = clazzMetricSummaries.size();
        int totalInterfaceImplementations = 0;
        double totalDit = 0;
        double totalWmc = 0;
        double totalNumFields = 0;
        double totalRfc = 0;

        for (ClassSummaryDto classSummaryDto : clazzMetricSummaries) {
            totalInterfaceImplementations += classSummaryDto.getInterfaces().getNumberOfInterfacesImplemented();
            totalDit += classSummaryDto.getDit().getValue();
            totalWmc += classSummaryDto.getWmc().getValue();
            totalNumFields += classSummaryDto.getNumFields().getTotalNumberOfFields();
            totalRfc += classSummaryDto.getRfc().getTotal();
        }

        summaryDto.setNumberOfClasses(numberOfClasses);
        summaryDto.setNumberOfInterfaceImplementations(totalInterfaceImplementations / numberOfClasses);
        summaryDto.setAvgDit(totalDit / numberOfClasses);
        summaryDto.setAvgWmc(totalWmc / numberOfClasses);
        summaryDto.setAvgNumFields(totalNumFields / numberOfClasses);
        summaryDto.setAvgRFC(totalRfc / numberOfClasses);

        return summaryDto;
    }
}

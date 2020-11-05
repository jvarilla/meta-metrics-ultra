package classmetrics;

import aggregatemetrics.AggregateMetricCalculatorImpl;
import aggregatemetrics.AggregateMetricsCalculator;
import dit.DitCalculator;
import dit.DitCalculatorImpl;
import dto.MetricsResultsDto;
import dto.classsummary.ClassSummaryDto;
import interfaces.InterfacesCalculator;
import interfaces.InterfacesCalculatorImpl;
import numfields.NumFieldsCalculator;
import numfields.NumFieldsCalculatorImpl;
import rfc.RfcCalculator;
import rfc.RfcCalculatorImpl;
import testclasses.Parent;
import wmc.WmcCalculator;
import wmc.WmcCalculatorImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ClassMetricsCalculatorImpl implements ClassMetricsCalculator {
    private DitCalculator ditCalculator;
    private InterfacesCalculator interfacesCalculator;
    private NumFieldsCalculator numFieldsCalculator;
    private RfcCalculator rfcCalculator;
    private WmcCalculator wmcCalculator;
    private AggregateMetricsCalculator aggregateMetricsCalculator;

    public ClassMetricsCalculatorImpl() {
        this.ditCalculator = new DitCalculatorImpl();
        this.interfacesCalculator = new InterfacesCalculatorImpl();
        this.numFieldsCalculator = new NumFieldsCalculatorImpl();
        this.rfcCalculator = new RfcCalculatorImpl();
        this.wmcCalculator = new WmcCalculatorImpl();
        this.aggregateMetricsCalculator = new AggregateMetricCalculatorImpl();
    }

    @Override
    public MetricsResultsDto calculate(List<Class<?>> clazzes) {
        MetricsResultsDto metricsResultsDto = new MetricsResultsDto();

        List<ClassSummaryDto> classSummaryDtos = clazzes.stream().map(clazz -> {
            ClassSummaryDto classSummaryDto = new ClassSummaryDto();


            classSummaryDto.setClassName(clazz.getName());
            classSummaryDto.setDit(this.ditCalculator.calculate(clazz));
            classSummaryDto.setInterfaces(this.interfacesCalculator.calculate(clazz));
            classSummaryDto.setWmc(this.wmcCalculator.calculate(clazz));
            classSummaryDto.setNumFields(this.numFieldsCalculator.calculate(clazz));
            classSummaryDto.setRfc(this.rfcCalculator.calculate(clazz));

            return classSummaryDto;
        }).collect(Collectors.toList());

        metricsResultsDto.setClasses(classSummaryDtos);
        metricsResultsDto.setSummary(aggregateMetricsCalculator.calculate(classSummaryDtos));

        return metricsResultsDto;
    }
}

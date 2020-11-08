package meta.metrics.classmetrics;

import meta.metrics.aggregatemetrics.AggregateMetricCalculatorImpl;
import meta.metrics.aggregatemetrics.AggregateMetricsCalculator;
import meta.metrics.dit.DitCalculator;
import meta.metrics.dit.DitCalculatorImpl;
import meta.metrics.dto.MetricsResultsDto;
import meta.metrics.dto.ClassSummaryDto;
import meta.metrics.interfaces.InterfacesCalculator;
import meta.metrics.interfaces.InterfacesCalculatorImpl;
import meta.metrics.numfields.NumFieldsCalculator;
import meta.metrics.numfields.NumFieldsCalculatorImpl;
import meta.metrics.rfc.RfcCalculator;
import meta.metrics.rfc.RfcCalculatorImpl;
import meta.metrics.wmc.WmcCalculator;
import meta.metrics.wmc.WmcCalculatorImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ClassMetricsCalculatorImpl implements ClassMetricsCalculator {
    private DitCalculator ditCalculator;
    private InterfacesCalculator interfacesCalculator;
    private NumFieldsCalculator numFieldsCalculator;
    private RfcCalculator rfcCalculator;
    private WmcCalculator wmcCalculator;
    private AggregateMetricsCalculator aggregateMetricsCalculator;

    public ClassMetricsCalculatorImpl(DitCalculator ditCalculator, InterfacesCalculator interfacesCalculator,
                                      NumFieldsCalculator numFieldsCalculator, RfcCalculator rfcCalculator,
                                      WmcCalculator wmcCalculator,
                                      AggregateMetricsCalculator aggregateMetricsCalculator) {
        this.ditCalculator = ditCalculator;
        this.interfacesCalculator = interfacesCalculator;
        this.numFieldsCalculator = numFieldsCalculator;
        this.rfcCalculator = rfcCalculator;
        this.wmcCalculator = wmcCalculator;
        this.aggregateMetricsCalculator = aggregateMetricsCalculator;
    }

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

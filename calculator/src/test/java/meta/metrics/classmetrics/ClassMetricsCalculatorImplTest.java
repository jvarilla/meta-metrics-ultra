package meta.metrics.classmetrics;

import meta.metrics.aggregatemetrics.AggregateMetricsCalculator;
import meta.metrics.aggregatemetrics.SummaryDto;
import meta.metrics.classmetrics.testclasses.TestClass1;
import meta.metrics.classmetrics.testclasses.TestClass2;
import meta.metrics.dit.DitCalculator;
import meta.metrics.dit.DitMetricsDto;
import meta.metrics.dto.ClassSummaryDto;
import meta.metrics.dto.MetricsResultsDto;
import meta.metrics.interfaces.InterfacesCalculator;
import meta.metrics.interfaces.InterfacesMetricsDto;
import meta.metrics.numfields.NumFieldsCalculator;
import meta.metrics.numfields.NumFieldsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import meta.metrics.rfc.RfcCalculator;
import meta.metrics.rfc.RfcMetricsDto;
import meta.metrics.wmc.WmcCalculator;
import meta.metrics.wmc.WmcMetricsDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class Metrics Calculator")
class ClassMetricsCalculatorImplTest {
    ClassMetricsCalculator classMetricsCalculator;
    DitCalculator mockDitCalculator;
    InterfacesCalculator mockInterfacesCalculator;
    NumFieldsCalculator mockNumFieldsCalculator;
    RfcCalculator mockRfcCalculator;
    WmcCalculator mockWmcCalculator;
    AggregateMetricsCalculator mockAggregateMetricsCalculator;

    @BeforeEach
    void setUp() {
        this.mockDitCalculator = new DitCalculator() {
            @Override
            public DitMetricsDto calculate(Class classToAnalyze) {
                return new DitMetricsDto();
            }

            @Override
            public List<Class<?>> getAncestors(Class<?> clazz) {
                return null;
            }
        };
        this.mockInterfacesCalculator = new InterfacesCalculator() {
            @Override
            public InterfacesMetricsDto calculate(Class<?> theClass) {
                return new InterfacesMetricsDto();
            }
        };
        this.mockNumFieldsCalculator = new NumFieldsCalculator() {
            @Override
            public NumFieldsDto calculate(Class<?> theClass) {
                return new NumFieldsDto();
            }
        };
        this.mockRfcCalculator = new RfcCalculator() {
            @Override
            public RfcMetricsDto calculate(Class<?> theClass) {
                return new RfcMetricsDto();
            }
        };
        this.mockWmcCalculator = new WmcCalculator() {
            @Override
            public WmcMetricsDto calculate(Class classToAnalyze) {
                return new WmcMetricsDto();
            }
        };
        this.mockAggregateMetricsCalculator = new AggregateMetricsCalculator() {
            @Override
            public SummaryDto calculate(List<ClassSummaryDto> clazzMetricSummaries) {
                return new SummaryDto();
            }
        };


        this.classMetricsCalculator = new ClassMetricsCalculatorImpl(
                this.mockDitCalculator,
                this.mockInterfacesCalculator,
                this.mockNumFieldsCalculator,
                this.mockRfcCalculator,
                this.mockWmcCalculator,
                this.mockAggregateMetricsCalculator
        );
    }

    @Test
    @DisplayName("Should calculate Class metrics for empty list of classes")
    void calculateClassMetricsForEmptyClassList() {
        List<Class<?>> clazzes = new ArrayList<>();

        MetricsResultsDto metricsResultsDto = this.classMetricsCalculator.calculate(clazzes);

        assertNotNull(metricsResultsDto.getSummary());
        assertEquals(0, metricsResultsDto.getClasses().size());
    }

    @Test
    @DisplayName("Should calculate Class metrics for list of one class")
    void calculateClassMetricsForClassListOfOne() {
        List<Class<?>> clazzes = new ArrayList<>();
        clazzes.add(TestClass1.class);
        String testClass1Name = TestClass1.class.getName();

        MetricsResultsDto metricsResultsDto = this.classMetricsCalculator.calculate(clazzes);

        assertNotNull(metricsResultsDto.getSummary());
        assertEquals(1, metricsResultsDto.getClasses().size());

        ClassSummaryDto summaryOfFirstClassInList = metricsResultsDto.getClasses().get(0);
        assertEquals(testClass1Name, summaryOfFirstClassInList.getClassName());
        assertNotNull(summaryOfFirstClassInList.getDit());
        assertNotNull(summaryOfFirstClassInList.getInterfaces());
        assertNotNull(summaryOfFirstClassInList.getNumFields());
        assertNotNull(summaryOfFirstClassInList.getRfc());
        assertNotNull(summaryOfFirstClassInList.getWmc());
    }

    @Test
    @DisplayName("Should calculate Class metrics for list of multiple classes")
    void calculateClassMetricsForListOfMultipleClasses() {
        List<Class<?>> clazzes = new ArrayList<>();
        clazzes.add(TestClass1.class);
        clazzes.add(TestClass2.class);

        String testClass1Name = TestClass1.class.getName();
        String testClass2Name = TestClass2.class.getName();

        MetricsResultsDto metricsResultsDto = this.classMetricsCalculator.calculate(clazzes);

        assertNotNull(metricsResultsDto.getSummary());
        assertEquals(2, metricsResultsDto.getClasses().size());

        ClassSummaryDto summaryOfFirstClassInList = metricsResultsDto.getClasses().get(0);
        assertEquals(testClass1Name, summaryOfFirstClassInList.getClassName());
        assertNotNull(summaryOfFirstClassInList.getDit());
        assertNotNull(summaryOfFirstClassInList.getInterfaces());
        assertNotNull(summaryOfFirstClassInList.getNumFields());
        assertNotNull(summaryOfFirstClassInList.getRfc());
        assertNotNull(summaryOfFirstClassInList.getWmc());

        ClassSummaryDto summaryOfSecondClassInList = metricsResultsDto.getClasses().get(1);
        assertEquals(testClass2Name, summaryOfSecondClassInList.getClassName());
        assertNotNull(summaryOfSecondClassInList.getDit());
        assertNotNull(summaryOfSecondClassInList.getInterfaces());
        assertNotNull(summaryOfSecondClassInList.getNumFields());
        assertNotNull(summaryOfSecondClassInList.getRfc());
        assertNotNull(summaryOfSecondClassInList.getWmc());
    }

}
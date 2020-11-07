package aggregatemetrics;

import dit.DitMetricsDto;
import dto.ClassSummaryDto;
import interfaces.InterfacesMetricsDto;
import numfields.NumFieldsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rfc.RfcMetricsDto;
import wmc.WmcMetricsDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Aggregate Metrics Calculator")
class AggregateMetricCalculatorImplTest {
    AggregateMetricsCalculator aggregateMetricsCalculator;

    @BeforeEach
    void setUp() {
        this.aggregateMetricsCalculator = new AggregateMetricCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate Aggregate metrics for an empty list")
    void calculateAggregateMetricsForEmptyList() {
        List<ClassSummaryDto> emptyList = new ArrayList<>();
        SummaryDto summaryDto = this.aggregateMetricsCalculator.calculate(emptyList);
        assertEquals(0, summaryDto.getAvgDit());
        assertEquals(0, summaryDto.getAvgNumFields());
        assertEquals(0, summaryDto.getAvgRFC());
        assertEquals(0, summaryDto.getAvgWmc());
    }

    @Test
    @DisplayName("Should calculate Aggregate metrics for list of one class summary")
    void calculateAggregateMetricsForListOfOne() {
        DitMetricsDto ditMetricsDto = new DitMetricsDto();
        ditMetricsDto.setValue(1);

        InterfacesMetricsDto interfacesMetricsDto = new InterfacesMetricsDto();
        interfacesMetricsDto.setNumberOfInterfacesImplemented(1);

        NumFieldsDto numFieldsDto = new NumFieldsDto();
        numFieldsDto.setTotalFields(1);

        RfcMetricsDto rfcMetricsDto = new RfcMetricsDto();
        rfcMetricsDto.setTotal(1);

        WmcMetricsDto wmcMetricsDto = new WmcMetricsDto();
        wmcMetricsDto.setValue(1);


        ClassSummaryDto classSummaryDto = new ClassSummaryDto();
        classSummaryDto.setClassName("Class1");
        classSummaryDto.setDit(ditMetricsDto);
        classSummaryDto.setInterfaces(interfacesMetricsDto);
        classSummaryDto.setNumFields(numFieldsDto);
        classSummaryDto.setRfc(rfcMetricsDto);
        classSummaryDto.setWmc(wmcMetricsDto);

        List<ClassSummaryDto> listOfOne = new ArrayList<>();
        listOfOne.add(classSummaryDto);

        SummaryDto summaryDto = this.aggregateMetricsCalculator.calculate(listOfOne);
        assertEquals(1, summaryDto.getAvgDit());
        assertEquals(1, summaryDto.getNumberOfInterfaceImplementations());
        assertEquals(1, summaryDto.getAvgNumFields());
        assertEquals(1, summaryDto.getAvgRFC());
        assertEquals(1, summaryDto.getAvgWmc());
    }

    @Test
    @DisplayName("Should calculate Aggregate metrics for list of multiple class summary")
    void calculateAggregateMetricsForListOfMultiple() {
        DitMetricsDto ditMetricsDto1 = new DitMetricsDto();
        ditMetricsDto1.setValue(1);

        InterfacesMetricsDto interfacesMetricsDto1 = new InterfacesMetricsDto();
        interfacesMetricsDto1.setNumberOfInterfacesImplemented(1);

        NumFieldsDto numFieldsDto1 = new NumFieldsDto();
        numFieldsDto1.setTotalFields(1);

        RfcMetricsDto rfcMetricsDto1 = new RfcMetricsDto();
        rfcMetricsDto1.setTotal(1);

        WmcMetricsDto wmcMetricsDto1 = new WmcMetricsDto();
        wmcMetricsDto1.setValue(1);


        ClassSummaryDto classSummaryDto1 = new ClassSummaryDto();
        classSummaryDto1.setClassName("Class1");
        classSummaryDto1.setDit(ditMetricsDto1);
        classSummaryDto1.setInterfaces(interfacesMetricsDto1);
        classSummaryDto1.setNumFields(numFieldsDto1);
        classSummaryDto1.setRfc(rfcMetricsDto1);
        classSummaryDto1.setWmc(wmcMetricsDto1);

        DitMetricsDto ditMetricsDto2 = new DitMetricsDto();
        ditMetricsDto2.setValue(0);

        InterfacesMetricsDto interfacesMetricsDto2 = new InterfacesMetricsDto();
        interfacesMetricsDto2.setNumberOfInterfacesImplemented(0);

        NumFieldsDto numFieldsDto2 = new NumFieldsDto();
        numFieldsDto2.setTotalFields(0);

        RfcMetricsDto rfcMetricsDto2 = new RfcMetricsDto();
        rfcMetricsDto2.setTotal(0);

        WmcMetricsDto wmcMetricsDto2 = new WmcMetricsDto();
        wmcMetricsDto2.setValue(0);


        ClassSummaryDto classSummaryDto2 = new ClassSummaryDto();
        classSummaryDto2.setClassName("Class2");
        classSummaryDto2.setDit(ditMetricsDto2);
        classSummaryDto2.setInterfaces(interfacesMetricsDto2);
        classSummaryDto2.setNumFields(numFieldsDto2);
        classSummaryDto2.setRfc(rfcMetricsDto2);
        classSummaryDto2.setWmc(wmcMetricsDto2);


        List<ClassSummaryDto> listOfTwo = new ArrayList<>();
        listOfTwo.add(classSummaryDto1);
        listOfTwo.add(classSummaryDto2);

        SummaryDto summaryDto = this.aggregateMetricsCalculator.calculate(listOfTwo);

        assertEquals(0.5, summaryDto.getAvgDit());
        assertEquals(1, summaryDto.getNumberOfInterfaceImplementations());
        assertEquals(0.5, summaryDto.getAvgNumFields());
        assertEquals(0.5, summaryDto.getAvgRFC());
        assertEquals(0.5, summaryDto.getAvgWmc());
    }
}
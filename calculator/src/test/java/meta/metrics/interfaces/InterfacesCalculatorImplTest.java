package meta.metrics.interfaces;

import meta.metrics.interfaces.testclasses.classes.ChildOfClassThatImplementsOneInterfaceButImplementsNoNewInterfaces;
import meta.metrics.interfaces.testclasses.classes.ClassThatImplementsNoInterfaces;
import meta.metrics.interfaces.testclasses.classes.ClassThatImplementsOneInterface;
import meta.metrics.interfaces.testclasses.classes.ClassThatImplementsTwoInterfaces;
import meta.metrics.interfaces.testclasses.interfaces.InterfaceA;
import meta.metrics.interfaces.testclasses.interfaces.InterfaceB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Interfaces Calculator")
class InterfacesCalculatorImplTest {
    InterfacesCalculator interfacesCalculator;

    @BeforeEach
    void setup() {
        this.interfacesCalculator = new InterfacesCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.interfaces for class that implements no varilla.joseph.interfaces")
    void calculateNoInterfaces() {
        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(ClassThatImplementsNoInterfaces.class);

        assertEquals(0, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(0, interfacesMetricsDto.getInterfacesImplemented().size());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.interfaces for class that implements one varilla.joseph.interfaces")
    void calculateOneInterface() {
        String interfaceAName = InterfaceA.class.getName();
        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(ClassThatImplementsOneInterface.class);

        assertEquals(1, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(1, interfacesMetricsDto.getInterfacesImplemented().size());
        assertTrue(interfacesMetricsDto.getInterfacesImplemented().contains(interfaceAName));
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.interfaces for class that implements multiple varilla.joseph.interfaces")
    void calculateMultipleInterface() {
        String interfaceAName = InterfaceA.class.getName();
        String interfaceBName = InterfaceB.class.getName();

        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(ClassThatImplementsTwoInterfaces.class);

        assertEquals(2, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(2, interfacesMetricsDto.getInterfacesImplemented().size());
        assertTrue(interfacesMetricsDto.getInterfacesImplemented().contains(interfaceAName));
        assertTrue(interfacesMetricsDto.getInterfacesImplemented().contains(interfaceBName));
    }

    @Test
    @DisplayName("Should not calculate varilla.joseph.interfaces implemented in the parent of a class")
    void calculateOneInheritedInterface() {
        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(
               ChildOfClassThatImplementsOneInterfaceButImplementsNoNewInterfaces.class);

        assertEquals(0, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(0, interfacesMetricsDto.getInterfacesImplemented().size());
    }
}
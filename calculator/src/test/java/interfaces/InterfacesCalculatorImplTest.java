package interfaces;

import interfaces.testclasses.classes.ChildOfClassThatImplementsOneInterfaceButImplementsNoNewInterfaces;
import interfaces.testclasses.classes.ClassThatImplementsNoInterfaces;
import interfaces.testclasses.classes.ClassThatImplementsOneInterface;
import interfaces.testclasses.classes.ClassThatImplementsTwoInterfaces;
import interfaces.testclasses.interfaces.InterfaceA;
import interfaces.testclasses.interfaces.InterfaceB;
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
    @DisplayName("Should calculate interfaces for class that implements no interfaces")
    void calculateNoInterfaces() {
        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(ClassThatImplementsNoInterfaces.class);

        assertEquals(0, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(0, interfacesMetricsDto.getInterfacesImplemented().size());
    }

    @Test
    @DisplayName("Should calculate interfaces for class that implements one interfaces")
    void calculateOneInterface() {
        String interfaceAName = InterfaceA.class.getName();
        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(ClassThatImplementsOneInterface.class);

        assertEquals(1, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(1, interfacesMetricsDto.getInterfacesImplemented().size());
        assertTrue(interfacesMetricsDto.getInterfacesImplemented().contains(interfaceAName));
    }

    @Test
    @DisplayName("Should calculate interfaces for class that implements multiple interfaces")
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
    @DisplayName("Should not calculate interfaces implemented in the parent of a class")
    void calculateOneInheritedInterface() {
        InterfacesMetricsDto interfacesMetricsDto;
        interfacesMetricsDto = this.interfacesCalculator.calculate(
               ChildOfClassThatImplementsOneInterfaceButImplementsNoNewInterfaces.class);

        assertEquals(0, interfacesMetricsDto.getNumberOfInterfacesImplemented());
        assertEquals(0, interfacesMetricsDto.getInterfacesImplemented().size());
    }
}
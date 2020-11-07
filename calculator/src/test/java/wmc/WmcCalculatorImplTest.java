package wmc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wmc.testclasses.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Wmc Calculator Test")
class WmcCalculatorImplTest {
    private WmcCalculator wmcCalculator;

    @BeforeEach
    void setUp() {
        this.wmcCalculator = new WmcCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate wmc for a class with no method and one constructor")
    void calculateWmcWithNoMethods() {
        WmcMetricsDto results = this.wmcCalculator.calculate(NoMethodClass.class);

        assertEquals(results.getValue(), 1);
        assertEquals(results.getNumberOfConstructors(), 1);
        assertEquals(results.getNumberOfMethods().getTotalMethods(), 0);
    }

    @Test
    @DisplayName("Should calculate wmc for a class with one method and one constructor")
    void calculateWmcWithOneMethod() {
        WmcMetricsDto results = this.wmcCalculator.calculate(OneMethodClass.class);

        assertEquals(results.getValue(), 2);
        assertEquals(results.getNumberOfConstructors(), 1);
        assertEquals(results.getNumberOfMethods().getTotalMethods(), 1);
    }

    @Test
    @DisplayName("Should calculate wmc for a class with one method of each of 4 modifiers " +
            "type and one constructor")
    void calculateWmcWithOneMethodOfEachAccessibilityModifiers() {
        WmcMetricsDto results =
                this.wmcCalculator.calculate(OneMethodOfEachOfAccessibilityModifiersClass.class);

        assertEquals(results.getValue(), 5);
        assertEquals(results.getNumberOfConstructors(), 1);
        assertEquals(results.getNumberOfMethods().getTotalMethods(), 4);
        assertEquals(results.getNumberOfMethods().getPublicMethods(), 1);
        assertEquals(results.getNumberOfMethods().getProtectedMethods(), 1);
        assertEquals(results.getNumberOfMethods().getPrivateMethods(), 1);
        assertEquals(results.getNumberOfMethods().getPackagePrivateMethods(), 1);
    }

    @Test
    @DisplayName("Should calculate wmc for a class with one static method and one constructor")
    void calculateWmcWithOneStaticMethod() {
        WmcMetricsDto results =
                this.wmcCalculator.calculate(OneStaticMethodClass.class);

        assertEquals(results.getValue(), 2);
        assertEquals(results.getNumberOfConstructors(), 1);
        assertEquals(results.getNumberOfMethods().getTotalMethods(), 1);
        assertEquals(results.getNumberOfMethods().getStaticMethods(), 1);
    }

    @Test
    @DisplayName("Should calculate wmc for a class with multiple constructors")
    void calculateWmcWithMultipleConstructors() {
        WmcMetricsDto results = this.wmcCalculator.calculate(MultipleConstructorClass.class);

        assertEquals(results.getValue(), 2);
        assertEquals(results.getNumberOfConstructors(), 2);
        assertEquals(results.getNumberOfMethods().getTotalMethods(), 0);
    }



}
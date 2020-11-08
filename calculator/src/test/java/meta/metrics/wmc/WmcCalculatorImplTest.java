package meta.metrics.wmc;

import meta.metrics.wmc.testclasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import meta.metrics.wmc.testclasses.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Wmc Calculator")
class WmcCalculatorImplTest {
    private WmcCalculator wmcCalculator;

    @BeforeEach
    void setUp() {
        this.wmcCalculator = new WmcCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.wmc for a class with no method and one constructor")
    void calculateWmcWithNoMethods() {
        WmcMetricsDto results = this.wmcCalculator.calculate(NoMethodClass.class);

        assertEquals(1, results.getValue());
        assertEquals(1, results.getNumberOfConstructors());
        assertEquals(0, results.getNumberOfMethods().getTotalMethods());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.wmc for a class with one method and one constructor")
    void calculateWmcWithOneMethod() {
        WmcMetricsDto results = this.wmcCalculator.calculate(OneMethodClass.class);

        assertEquals(2, results.getValue());
        assertEquals(1, results.getNumberOfConstructors());
        assertEquals(1, results.getNumberOfMethods().getTotalMethods());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.wmc for a class with one method of each of 4 modifiers " +
            "type and one constructor")
    void calculateWmcWithOneMethodOfEachAccessibilityModifiers() {
        WmcMetricsDto results =
                this.wmcCalculator.calculate(OneMethodOfEachOfAccessibilityModifierClass.class);

        assertEquals(5, results.getValue());
        assertEquals(1, results.getNumberOfConstructors());
        assertEquals(4, results.getNumberOfMethods().getTotalMethods());
        assertEquals(1, results.getNumberOfMethods().getPublicMethods());
        assertEquals(1, results.getNumberOfMethods().getProtectedMethods());
        assertEquals(1, results.getNumberOfMethods().getPrivateMethods());
        assertEquals(1, results.getNumberOfMethods().getPackagePrivateMethods());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.wmc for a class with one static method and one constructor")
    void calculateWmcWithOneStaticMethod() {
        WmcMetricsDto results =
                this.wmcCalculator.calculate(OneStaticMethodClass.class);

        assertEquals(2, results.getValue());
        assertEquals(1, results.getNumberOfConstructors());
        assertEquals(1, results.getNumberOfMethods().getTotalMethods());
        assertEquals(1, results.getNumberOfMethods().getStaticMethods());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.wmc for a class with multiple constructors")
    void calculateWmcWithMultipleConstructors() {
        WmcMetricsDto results = this.wmcCalculator.calculate(MultipleConstructorClass.class);

        assertEquals(2, results.getValue());
        assertEquals(2, results.getNumberOfConstructors());
        assertEquals(0, results.getNumberOfMethods().getTotalMethods());
    }

    @Test
    @DisplayName("Should exclude lambdas from varilla.joseph.wmc count")
    void calculateWmcWithLambdaMethod() {
        WmcMetricsDto results = this.wmcCalculator.calculate(LambdaMethodClass.class);

        assertEquals(1, results.getValue());
        assertEquals(1, results.getNumberOfConstructors());
        assertEquals(0, results.getNumberOfMethods().getTotalMethods());
    }



}
package meta.metrics.numfields;

import meta.metrics.numfields.testclasses.OneFieldOfEachAccessibilityModifierClass;
import meta.metrics.numfields.testclasses.OneStaticFieldClass;
import meta.metrics.numfields.testclasses.NoFieldsClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NumFields Calculator")
class NumFieldsCalculatorImplTest {
    NumFieldsCalculator numFieldsCalculator;

    @BeforeEach
    void setUp() {
        this.numFieldsCalculator = new NumFieldsCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate NumFields metrics for class with no fields")
    void calculateNoFields() {
        NumFieldsDto results = this.numFieldsCalculator.calculate(NoFieldsClass.class);

        assertEquals(0, results.getTotalFields());
    }

    @Test
    @DisplayName("Should calculate NumFields metrics for class with one static field")
    void calculateOneStaticFields() {
        NumFieldsDto results = this.numFieldsCalculator.calculate(OneStaticFieldClass.class);

        assertEquals(1, results.getTotalFields());
        assertEquals(1, results.getStaticFields());
    }

    @Test
    @DisplayName("Should calculate NumFields metrics for class with one field of " +
            "with one of each accessibility modifier")
    void calculateOneOfEachAccessibilityModifierFields() {
        NumFieldsDto results = this.numFieldsCalculator.calculate(
                OneFieldOfEachAccessibilityModifierClass.class);

        assertEquals(4, results.getTotalFields());
        assertEquals(1, results.getPublicFields());
        assertEquals(1, results.getProtectedFields());
        assertEquals(1, results.getPackagePrivateFields());
        assertEquals(1, results.getPrivateFields());
    }
}
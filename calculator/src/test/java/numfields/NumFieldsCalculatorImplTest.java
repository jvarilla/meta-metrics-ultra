package numfields;

import numfields.testclasses.NoFieldsClass;
import numfields.testclasses.OneFieldOfEachAccessibilityModifierClass;
import numfields.testclasses.OneStaticFieldClass;
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
    @DisplayName("Should calculate field metrics for class with no fields")
    void calculateNoFields() {
        NumFieldsDto results = this.numFieldsCalculator.calculate(NoFieldsClass.class);

        assertEquals(results.getTotalFields(), 0);
    }

    @Test
    @DisplayName("Should calculate field metrics for class with one static field")
    void calculateOneStaticFields() {
        NumFieldsDto results = this.numFieldsCalculator.calculate(OneStaticFieldClass.class);

        assertEquals(results.getTotalFields(), 1);
        assertEquals(results.getStaticFields(), 1);
    }

    @Test
    @DisplayName("Should calculate field metrics for class with one field of " +
            "with one of each accessibility modifier")
    void calculateOneOfEachAccessibilityModifierFields() {
        NumFieldsDto results = this.numFieldsCalculator.calculate(
                OneFieldOfEachAccessibilityModifierClass.class);

        assertEquals(results.getTotalFields(), 4);
        assertEquals(results.getPublicFields(), 1);
        assertEquals(results.getProtectedFields(), 1);
        assertEquals(results.getPackagePrivateFields(), 1);
        assertEquals(results.getPrivateFields(), 1);
    }
}
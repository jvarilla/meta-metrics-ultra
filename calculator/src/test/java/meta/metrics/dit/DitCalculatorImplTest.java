package meta.metrics.dit;

import meta.metrics.dit.testclasses.ChildOne;
import meta.metrics.dit.testclasses.GrandChildOne;
import meta.metrics.dit.testclasses.Parent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dit Calculator")
class DitCalculatorImplTest {
    private DitCalculator ditCalculator;

    @BeforeEach
    void setUp() {
        this.ditCalculator = new DitCalculatorImpl();
    }

    @Test
    @DisplayName("Should correctly calculate Dit for class with no ancestors")
    void calculateDitWithNoAncestors() {
        Class<Parent> classWithNoAncestors = Parent.class;

        DitMetricsDto results = this.ditCalculator.calculate(classWithNoAncestors);


        assertEquals(0, results.getValue());
        assertTrue(results.getAncestors().isEmpty());
    }

    @Test
    @DisplayName("Should correctly calculate Dit for class with one ancestors")
    void calculateDitWithOneAncestors() {
        Class<ChildOne> classWithOneAncestor = ChildOne.class;

        DitMetricsDto results = this.ditCalculator.calculate(classWithOneAncestor);

        assertEquals(1, results.getValue());
        assertEquals(1, results.getAncestors().size());
    }

    @Test
    @DisplayName("Should correctly calculate Dit for class with multiple ancestors")
    void calculateDitWithMultipleAncestors() {
        Class<GrandChildOne> classWithTwoAncestors = GrandChildOne.class;

        DitMetricsDto results = this.ditCalculator.calculate(classWithTwoAncestors);

        assertEquals(2, results.getValue());
        assertEquals(2, results.getAncestors().size());
    }

}
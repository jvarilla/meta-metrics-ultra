package dit;

import dto.classsummary.dit.DitMetricsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testclasses.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dit Calculator Test")
class DitCalculatorImplTest {
    private DitCalculator ditCalculator;

    @BeforeEach
    void setUp() {
        this.ditCalculator = new DitCalculatorImpl();
    }

    @Test
    @DisplayName("Should correctly calculate DIT for class with no ancestors")
    void calculateDitWithNoAncestors() {
        Class<Parent> classWithNoAncestors = Parent.class;

        DitMetricsDto results = this.ditCalculator.calculate(classWithNoAncestors);

        assertEquals(results.getValue(), 0);
        assertTrue(results.getAncestors().isEmpty());
    }

    @Test
    @DisplayName("Should correctly calculate DIT for class with one ancestors")
    void calculateDitWithOneAncestors() {
        Class<ChildOne> classWithOneAncestor = ChildOne.class;

        DitMetricsDto results = this.ditCalculator.calculate(classWithOneAncestor);

        assertEquals(results.getValue(), 1);
        assertEquals(results.getAncestors().size(), 1);
    }

    @Test
    @DisplayName("Should correctly calculate DIT for class with multiple ancestors")
    void calculateDitWithMultipleAncestors() {
        Class<GrandChildOne> classWithTwoAncestors = GrandChildOne.class;

        DitMetricsDto results = this.ditCalculator.calculate(classWithTwoAncestors);

        assertEquals(results.getValue(), 2);
        assertEquals(results.getAncestors().size(), 2);
    }

}
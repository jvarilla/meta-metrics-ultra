package wmc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WmcCalculatorImplTest {
    private WmcCalculator wmcCalculator;

    @BeforeEach
    void setUp() {
        this.wmcCalculator = new WmcCalculatorImpl();
    }

    @Test
    @DisplayName("Should Calculate")
    void calculate() {
    }
}
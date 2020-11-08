package meta.metrics.rfc;

import meta.metrics.rfc.testclasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import meta.metrics.rfc.testclasses.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Rfc Calculator")
class RfcCalculatorImplTest {
    RfcCalculator rfcCalculator;

    @BeforeEach
    void setUp() {
        this.rfcCalculator = new RfcCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.rfc metrics for class with no methods")
    void calculateRfcForClassWithNoMethods() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(ClassWithNoMethods.class);

        assertEquals(0, rfcMetricsDto.getTotal());
        assertEquals(0, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(0, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(0, rfcMetricsDto.getMethodsInherited());
        assertEquals(0, rfcMetricsDto.getNumberOfFieldObjects());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.rfc metrics for class with one method")
    void calculateRfcForClassWithOneMethod() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(ClassWithOneMethod.class);

        assertEquals(1, rfcMetricsDto.getTotal());
        assertEquals(1, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(0, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(0, rfcMetricsDto.getMethodsInherited());
        assertEquals(0, rfcMetricsDto.getNumberOfFieldObjects());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.rfc metrics for class that inherits one method but has no " +
            "declared methods of its own")
    void calculateRfcForClassWithOneInheritedAndNoDeclaredMethods() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(
                ClassThatInheritsOneMethod.class);

        assertEquals(1, rfcMetricsDto.getTotal());
        assertEquals(0, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(0, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(1, rfcMetricsDto.getMethodsInherited());
        assertEquals(0, rfcMetricsDto.getNumberOfFieldObjects());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.rfc metrics for class that inherits one method and has one " +
            "declared methods of its own")
    void calculateRfcForClassWithOneInheritedAndOneDeclaredMethods() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(
                ClassThatInheritsOneMethodAndDeclaresOneMethods.class);

        assertEquals(2, rfcMetricsDto.getTotal());
        assertEquals(1, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(0, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(1, rfcMetricsDto.getMethodsInherited());
        assertEquals(0, rfcMetricsDto.getNumberOfFieldObjects());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.rfc metrics for class that inherits two methods and has one " +
            "declared methods of its own and has one field obj with one method")
    void calculateRfcForClassWithTwoInheritedAndOneDeclaredAndOneFieldObjMethod() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(
              ClassThatInheritsTwoMethodsDeclaresOneMethodAndHasAFieldObjWithOneMethod.class);

        assertEquals(4, rfcMetricsDto.getTotal());
        assertEquals(1, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(1, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(2, rfcMetricsDto.getMethodsInherited());
        assertEquals(1, rfcMetricsDto.getNumberOfFieldObjects());
    }

    @Test
    @DisplayName("Should calculate varilla.joseph.rfc metrics for class that has three field obj methods " +
            "from two field objs")
    void calculateRfcForClassWithThreeFieldObjMethods() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(
                ClassThatHasThreeMethodsFromFieldObjs.class);

        assertEquals(3, rfcMetricsDto.getTotal());
        assertEquals(0, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(3, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(0, rfcMetricsDto.getMethodsInherited());
        assertEquals(2, rfcMetricsDto.getNumberOfFieldObjects());
    }

    @Test
    @DisplayName("Should not double count methods from multiple fields of the same type")
    void calculateRfcForClassWithTwoFieldObjOfTheSameType() {
        RfcMetricsDto rfcMetricsDto = this.rfcCalculator.calculate(
                ClassWithTwoOfTheSameFieldObj.class);

        assertEquals(1, rfcMetricsDto.getTotal());
        assertEquals(0, rfcMetricsDto.getMethodsFromCurrentClass());
        assertEquals(1, rfcMetricsDto.getMethodsFromFieldObjects());
        assertEquals(0, rfcMetricsDto.getMethodsInherited());
        assertEquals(2, rfcMetricsDto.getNumberOfFieldObjects());
    }
}
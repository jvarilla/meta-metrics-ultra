package numfields;

import dto.classsummary.numfields.NumFieldsDto;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class NumFieldsCalculatorImpl implements NumFieldsCalculator {
    private Predicate<Field> privateFieldsCondition;
    private Predicate<Field> protectedFieldsCondition;
    private Predicate<Field> publicFieldsCondition;
    private Predicate<Field> staticFieldsCondition;

    public NumFieldsCalculatorImpl() {
        privateFieldsCondition = field -> Modifier.isPrivate(field.getModifiers());
        protectedFieldsCondition = field -> Modifier.isProtected(field.getModifiers());
        publicFieldsCondition = field -> Modifier.isPublic(field.getModifiers());
        staticFieldsCondition = field -> Modifier.isStatic(field.getModifiers());
    }

    @Override
    public NumFieldsDto calculate(Class<?> theClass) {
        NumFieldsDto numFieldsDto = new NumFieldsDto();

        Field[] fields =  theClass.getDeclaredFields();
        numFieldsDto.setTotalNumberOfFields(fields.length);
        numFieldsDto.setTotalPrivateFields(countNumFieldsWithCondition(fields, privateFieldsCondition));
        numFieldsDto.setTotalProtectedFields(countNumFieldsWithCondition(fields, protectedFieldsCondition));
        numFieldsDto.setTotalPublicFields(countNumFieldsWithCondition(fields, publicFieldsCondition));
        numFieldsDto.setTotalStaticFields( countNumFieldsWithCondition(fields, staticFieldsCondition));

        return numFieldsDto;
    }

    public int countNumFieldsWithCondition(Field[] fields, Predicate<Field> condition) {
        return Arrays.stream(fields)
                .filter(condition).toArray().length;
    }
}
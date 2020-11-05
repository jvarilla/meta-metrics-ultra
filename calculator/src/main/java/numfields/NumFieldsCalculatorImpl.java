package numfields;

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
        numFieldsDto.setTotalFields(fields.length);
        numFieldsDto.setPrivateFields(countNumFieldsWithCondition(fields, privateFieldsCondition));
        numFieldsDto.setProtectedFields(countNumFieldsWithCondition(fields, protectedFieldsCondition));
        numFieldsDto.setPublicFields(countNumFieldsWithCondition(fields, publicFieldsCondition));
        numFieldsDto.setStaticFields( countNumFieldsWithCondition(fields, staticFieldsCondition));

        return numFieldsDto;
    }

    public int countNumFieldsWithCondition(Field[] fields, Predicate<Field> condition) {
        return Arrays.stream(fields)
                .filter(condition).toArray().length;
    }
}
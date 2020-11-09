package meta.metrics.rfc.testclasses;

public class ClassThatHasThreeMethodsFromFieldObjs {
    int intField;
    double doubleField;
    int[] primitiveArrayField;
    char charField;
    boolean booleanField;
    byte byteField;
    FieldObjClassOneMethod fieldObjClassOneMethod;
    FieldObjClassTwoMethod fieldObjClassTwoMethod;

    ClassThatHasThreeMethodsFromFieldObjs() {
        fieldObjClassOneMethod = new FieldObjClassOneMethod();
        fieldObjClassTwoMethod = new FieldObjClassTwoMethod();
    }
}

package meta.metrics.rfc.testclasses;

public class ClassThatInheritsTwoMethodsDeclaresOneMethodAndHasAFieldObjWithOneMethod
        extends ClassThatInheritsOneMethodAndDeclaresOneMethods {
    int intField;
    double doubleField;
    int[] primitiveArrayField;
    char charField;
    boolean booleanField;
    byte byteField;
    FieldObjClassOneMethod fieldObjClassOneMethod;

    ClassThatInheritsTwoMethodsDeclaresOneMethodAndHasAFieldObjWithOneMethod() {
        fieldObjClassOneMethod = new FieldObjClassOneMethod();
    }

    public void grandchildDeclaredMethod() { }
}

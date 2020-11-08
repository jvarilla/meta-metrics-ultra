package meta.metrics.rfc;

public class RfcMetricsDto {
    private int total;
    private int methodsFromCurrentClass;
    private int methodsFromFieldObjects;
    private int methodsInherited;
    private int numberOfFieldObjects;

    public RfcMetricsDto() {
    }

    public RfcMetricsDto(int total, int methodsFromCurrentClass, int methodsFromFieldObjects, int methodsInherited, int numberOfFieldObjects) {
        this.total = total;
        this.methodsFromCurrentClass = methodsFromCurrentClass;
        this.methodsFromFieldObjects = methodsFromFieldObjects;
        this.methodsInherited = methodsInherited;
        this.numberOfFieldObjects = numberOfFieldObjects;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMethodsFromCurrentClass() {
        return methodsFromCurrentClass;
    }

    public void setMethodsFromCurrentClass(int methodsFromCurrentClass) {
        this.methodsFromCurrentClass = methodsFromCurrentClass;
    }

    public int getMethodsFromFieldObjects() {
        return methodsFromFieldObjects;
    }

    public void setMethodsFromFieldObjects(int methodsFromFieldObjects) {
        this.methodsFromFieldObjects = methodsFromFieldObjects;
    }

    public int getMethodsInherited() {
        return methodsInherited;
    }

    public void setMethodsInherited(int methodsInherited) {
        this.methodsInherited = methodsInherited;
    }

    public int getNumberOfFieldObjects() {
        return numberOfFieldObjects;
    }

    public void setNumberOfFieldObjects(int numberOfFieldObjects) {
        this.numberOfFieldObjects = numberOfFieldObjects;
    }
}

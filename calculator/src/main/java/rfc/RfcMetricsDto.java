package rfc;

public class RfcMetricsDto {
    private int total;
    private int numberOfMethodsFromCurrentClass;
    private int numberOfMethodsFromFieldObjects;
    private int numberOfInheritedMethods;
    private int numberOfFieldObjects;

    public RfcMetricsDto() {
    }

    public RfcMetricsDto(int total, int numberOfMethodsFromCurrentClass, int numberOfMethodsFromFieldObjects, int numberOfInheritedMethods, int numberOfFieldObjects) {
        this.total = total;
        this.numberOfMethodsFromCurrentClass = numberOfMethodsFromCurrentClass;
        this.numberOfMethodsFromFieldObjects = numberOfMethodsFromFieldObjects;
        this.numberOfInheritedMethods = numberOfInheritedMethods;
        this.numberOfFieldObjects = numberOfFieldObjects;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumberOfMethodsFromCurrentClass() {
        return numberOfMethodsFromCurrentClass;
    }

    public void setNumberOfMethodsFromCurrentClass(int numberOfMethodsFromCurrentClass) {
        this.numberOfMethodsFromCurrentClass = numberOfMethodsFromCurrentClass;
    }

    public int getNumberOfMethodsFromFieldObjects() {
        return numberOfMethodsFromFieldObjects;
    }

    public void setNumberOfMethodsFromFieldObjects(int numberOfMethodsFromFieldObjects) {
        this.numberOfMethodsFromFieldObjects = numberOfMethodsFromFieldObjects;
    }

    public int getNumberOfInheritedMethods() {
        return numberOfInheritedMethods;
    }

    public void setNumberOfInheritedMethods(int numberOfInheritedMethods) {
        this.numberOfInheritedMethods = numberOfInheritedMethods;
    }

    public int getNumberOfFieldObjects() {
        return numberOfFieldObjects;
    }

    public void setNumberOfFieldObjects(int numberOfFieldObjects) {
        this.numberOfFieldObjects = numberOfFieldObjects;
    }
}

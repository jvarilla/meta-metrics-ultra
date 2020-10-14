package dto.classsummary.rfc;

public class RfcMetricsDto {
    private int total;
    private int numberOfMethodsFromCurrentClass;
    private int numberOfMethodsFromFieldObjects;
    private int numberOfFieldObjects;

    public RfcMetricsDto(int total, int numberOfMethodsFromCurrentClass, int numberOfMethodsFromFieldObjects, int numberOfFieldObjects) {
        this.total = total;
        this.numberOfMethodsFromCurrentClass = numberOfMethodsFromCurrentClass;
        this.numberOfMethodsFromFieldObjects = numberOfMethodsFromFieldObjects;
        this.numberOfFieldObjects = numberOfFieldObjects;
    }

    public RfcMetricsDto() {
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

    public int getNumberOfFieldObjects() {
        return numberOfFieldObjects;
    }

    public void setNumberOfFieldObjects(int numberOfFieldObjects) {
        this.numberOfFieldObjects = numberOfFieldObjects;
    }
}

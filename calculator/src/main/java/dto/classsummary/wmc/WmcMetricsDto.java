package dto.classsummary.wmc;

public class WmcMetricsDto {
    private int value;
    private int numberOfConstructors;
    private NumberOfMethodsDto numberOfMethods;

    public WmcMetricsDto(int value, int numberOfConstructors, NumberOfMethodsDto numberOfMethods) {
        this.value = value;
        this.numberOfConstructors = numberOfConstructors;
        this.numberOfMethods = numberOfMethods;
    }

    public WmcMetricsDto() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberOfConstructors() {
        return numberOfConstructors;
    }

    public void setNumberOfConstructors(int numberOfConstructors) {
        this.numberOfConstructors = numberOfConstructors;
    }

    public NumberOfMethodsDto getNumberOfMethods() {
        return numberOfMethods;
    }

    public void setNumberOfMethods(NumberOfMethodsDto numberOfMethods) {
        this.numberOfMethods = numberOfMethods;
    }

    @Override
    public String toString() {
        return "WmcMetricsDto{" +
                "value=" + value +
                ", numberOfConstructors=" + numberOfConstructors +
                ", numberOfMethods=" + numberOfMethods +
                '}';
    }
}

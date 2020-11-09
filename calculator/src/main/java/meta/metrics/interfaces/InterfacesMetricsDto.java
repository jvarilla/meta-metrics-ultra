package meta.metrics.interfaces;

import java.util.List;

public class InterfacesMetricsDto {
    private int numberOfInterfacesImplemented;
    private List<String> interfacesImplemented;

    public InterfacesMetricsDto(int numberOfInterfacesImplemented, List<String> interfacesImplemented) {
        this.numberOfInterfacesImplemented = numberOfInterfacesImplemented;
        this.interfacesImplemented = interfacesImplemented;
    }

    public InterfacesMetricsDto() {
    }

    public int getNumberOfInterfacesImplemented() {
        return numberOfInterfacesImplemented;
    }

    public void setNumberOfInterfacesImplemented(int numberOfInterfacesImplemented) {
        this.numberOfInterfacesImplemented = numberOfInterfacesImplemented;
    }

    public List<String> getInterfacesImplemented() {
        return interfacesImplemented;
    }

    public void setInterfacesImplemented(List<String> interfacesImplemented) {
        this.interfacesImplemented = interfacesImplemented;
    }

    @Override
    public String toString() {
        return "InterfacesMetricsDto{" +
                "numberOfInterfacesImplemented=" + numberOfInterfacesImplemented +
                ", interfacesImplemented=" + interfacesImplemented +
                '}';
    }
}

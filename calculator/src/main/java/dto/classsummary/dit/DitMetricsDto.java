package dto.classsummary.dit;

import java.util.List;

public class DitMetricsDto {
    private int value;
    private List<String> ancestors;

    public DitMetricsDto(int value, List<String> ancestors) {
        this.value = value;
        this.ancestors = ancestors;
    }

    public DitMetricsDto() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<String> getAncestors() {
        return ancestors;
    }

    public void setAncestors(List<String> ancestors) {
        this.ancestors = ancestors;
    }

    @Override
    public String toString() {
        return "DitMetricsDto{" +
                "value=" + value +
                ", ancestors=" + ancestors +
                '}';
    }
}

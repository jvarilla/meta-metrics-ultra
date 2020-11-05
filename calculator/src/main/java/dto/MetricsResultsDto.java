package dto;

import aggregatemetrics.SummaryDto;
import dto.classsummary.ClassSummaryDto;

import java.util.List;

public class MetricsResultsDto {
    private SummaryDto summary;
    private List<ClassSummaryDto> classes;

    public MetricsResultsDto() {
    }

    public MetricsResultsDto(SummaryDto summary, List<ClassSummaryDto> classes) {
        this.summary = summary;
        this.classes = classes;
    }

    public SummaryDto getSummary() {
        return summary;
    }

    public void setSummary(SummaryDto summary) {
        this.summary = summary;
    }

    public List<ClassSummaryDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassSummaryDto> classes) {
        this.classes = classes;
    }



}

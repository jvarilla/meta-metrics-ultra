package dto.classsummary;

import dto.classsummary.dit.DitMetricsDto;
import dto.classsummary.interfaces.InterfacesMetricsDto;
import dto.classsummary.numfields.NumFieldsDto;
import dto.classsummary.rfc.RfcMetricsDto;
import dto.classsummary.wmc.NumberOfMethodsDto;
import dto.classsummary.wmc.WmcMetricsDto;

public class ClassSummaryDto {
    private String className;
    private DitMetricsDto dit;
    private WmcMetricsDto wmc;
    private NumFieldsDto numFields;
    private RfcMetricsDto rfc;
    private InterfacesMetricsDto interfaces;

    public ClassSummaryDto(String className, DitMetricsDto dit, WmcMetricsDto wmc,
                           NumFieldsDto numFields, RfcMetricsDto rfc, InterfacesMetricsDto interfaces) {
        this.className = className;
        this.dit = dit;
        this.wmc = wmc;
        this.numFields = numFields;
        this.rfc = rfc;
        this.interfaces = interfaces;
    }

    public ClassSummaryDto() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public DitMetricsDto getDit() {
        return dit;
    }

    public void setDit(DitMetricsDto dit) {
        this.dit = dit;
    }

    public WmcMetricsDto getWmc() {
        return wmc;
    }

    public void setWmc(WmcMetricsDto wmc) {
        this.wmc = wmc;
    }

    public NumFieldsDto getNumFields() {
        return numFields;
    }

    public void setNumFields(NumFieldsDto numFields) {
        this.numFields = numFields;
    }

    public RfcMetricsDto getRfc() {
        return rfc;
    }

    public void setRfc(RfcMetricsDto rfc) {
        this.rfc = rfc;
    }

    public InterfacesMetricsDto getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(InterfacesMetricsDto interfaces) {
        this.interfaces = interfaces;
    }
}

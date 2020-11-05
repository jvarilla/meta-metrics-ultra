package dto;

import dit.DitMetricsDto;
import interfaces.InterfacesMetricsDto;
import numfields.NumFieldsDto;
import rfc.RfcMetricsDto;
import wmc.WmcMetricsDto;

public class ClassSummaryDto {
    private String className;
    private DitMetricsDto dit;
    private WmcMetricsDto wmc;
    private NumFieldsDto numFields;
    private RfcMetricsDto rfc;
    private InterfacesMetricsDto interfaces;

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

package aggregatemetrics;

public class SummaryDto {
    private String pathToSrc;
    private String pathToBin;
    private int loc;
    private int numberOfFiles;
    private int numberOfClasses;
    private int numberOfInterfaceImplementations;
    private double avgDit;
    private double avgWmc;
    private double avgNumFields;
    private double avgRFC;

    public String getPathToSrc() {
        return pathToSrc;
    }

    public void setPathToSrc(String pathToSrc) {
        this.pathToSrc = pathToSrc;
    }

    public String getPathToBin() {
        return pathToBin;
    }

    public void setPathToBin(String pathToBin) {
        this.pathToBin = pathToBin;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }

    public void setNumberOfFiles(int numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public int getNumberOfInterfaceImplementations() {
        return numberOfInterfaceImplementations;
    }

    public void setNumberOfInterfaceImplementations(int numberOfInterfaceImplementations) {
        this.numberOfInterfaceImplementations = numberOfInterfaceImplementations;
    }

    public double getAvgDit() {
        return avgDit;
    }

    public void setAvgDit(double avgDit) {
        this.avgDit = avgDit;
    }

    public double getAvgWmc() {
        return avgWmc;
    }

    public void setAvgWmc(double avgWmc) {
        this.avgWmc = avgWmc;
    }

    public double getAvgNumFields() {
        return avgNumFields;
    }

    public void setAvgNumFields(double avgNumFields) {
        this.avgNumFields = avgNumFields;
    }

    public double getAvgRFC() {
        return avgRFC;
    }

    public void setAvgRFC(double avgRFC) {
        this.avgRFC = avgRFC;
    }
}

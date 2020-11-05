package wmc;

public class NumberOfMethodsDto {
    private int totalNumberOfMethods;
    private int totalPrivateMethods;
    private int totalProtectedMethods;
    private int totalPublicMethods;
    private int totalStaticMethods;

    public NumberOfMethodsDto(int totalNumberOfMethods, int totalPrivateMethods, int totalProtectedMethods, int totalPublicMethods, int totalStaticMethods) {
        this.totalNumberOfMethods = totalNumberOfMethods;
        this.totalPrivateMethods = totalPrivateMethods;
        this.totalProtectedMethods = totalProtectedMethods;
        this.totalPublicMethods = totalPublicMethods;
        this.totalStaticMethods = totalStaticMethods;
    }

    public NumberOfMethodsDto() {
    }

    public int getTotalNumberOfMethods() {
        return totalNumberOfMethods;
    }

    public void setTotalNumberOfMethods(int totalNumberOfMethods) {
        this.totalNumberOfMethods = totalNumberOfMethods;
    }

    public int getTotalPrivateMethods() {
        return totalPrivateMethods;
    }

    public void setTotalPrivateMethods(int totalPrivateMethods) {
        this.totalPrivateMethods = totalPrivateMethods;
    }

    public int getTotalProtectedMethods() {
        return totalProtectedMethods;
    }

    public void setTotalProtectedMethods(int totalProtectedMethods) {
        this.totalProtectedMethods = totalProtectedMethods;
    }

    public int getTotalPublicMethods() {
        return totalPublicMethods;
    }

    public void setTotalPublicMethods(int totalPublicMethods) {
        this.totalPublicMethods = totalPublicMethods;
    }

    public int getTotalStaticMethods() {
        return totalStaticMethods;
    }

    public void setTotalStaticMethods(int totalStaticMethods) {
        this.totalStaticMethods = totalStaticMethods;
    }

    @Override
    public String toString() {
        return "NumberOfMethodsDto{" +
                "totalNumberOfMethods=" + totalNumberOfMethods +
                ", totalPrivateMethods=" + totalPrivateMethods +
                ", totalProtectedMethods=" + totalProtectedMethods +
                ", totalPublicMethods=" + totalPublicMethods +
                ", totalStaticMethods=" + totalStaticMethods +
                '}';
    }
}

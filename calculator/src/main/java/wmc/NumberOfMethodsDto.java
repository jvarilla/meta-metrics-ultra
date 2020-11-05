package wmc;

public class NumberOfMethodsDto {
    private int totalMethods;
    private int privateMethods;
    private int protectedMethods;
    private int publicMethods;
    private int staticMethods;

    public NumberOfMethodsDto(int totalMethods, int privateMethods, int protectedMethods, int publicMethods, int staticMethods) {
        this.totalMethods = totalMethods;
        this.privateMethods = privateMethods;
        this.protectedMethods = protectedMethods;
        this.publicMethods = publicMethods;
        this.staticMethods = staticMethods;
    }

    public NumberOfMethodsDto() {
    }

    public int getTotalMethods() {
        return totalMethods;
    }

    public void setTotalMethods(int totalMethods) {
        this.totalMethods = totalMethods;
    }

    public int getPrivateMethods() {
        return privateMethods;
    }

    public void setPrivateMethods(int privateMethods) {
        this.privateMethods = privateMethods;
    }

    public int getProtectedMethods() {
        return protectedMethods;
    }

    public void setProtectedMethods(int protectedMethods) {
        this.protectedMethods = protectedMethods;
    }

    public int getPublicMethods() {
        return publicMethods;
    }

    public void setPublicMethods(int publicMethods) {
        this.publicMethods = publicMethods;
    }

    public int getStaticMethods() {
        return staticMethods;
    }

    public void setStaticMethods(int staticMethods) {
        this.staticMethods = staticMethods;
    }

    @Override
    public String toString() {
        return "NumberOfMethodsDto{" +
                "totalNumberOfMethods=" + totalMethods +
                ", totalPrivateMethods=" + privateMethods +
                ", totalProtectedMethods=" + protectedMethods +
                ", totalPublicMethods=" + publicMethods +
                ", totalStaticMethods=" + staticMethods +
                '}';
    }
}

package wmc;

public class NumberOfMethodsDto {
    private int totalMethods;
    private int privateMethods;
    private int protectedMethods;
    private int publicMethods;
    private int packagePrivateMethods;
    private int staticMethods;

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

    public int getPackagePrivateMethods() {
        return packagePrivateMethods;
    }

    public void setPackagePrivateMethods(int packagePrivateMethods) {
        this.packagePrivateMethods = packagePrivateMethods;
    }

    public int getStaticMethods() {
        return staticMethods;
    }

    public void setStaticMethods(int staticMethods) {
        this.staticMethods = staticMethods;
    }
}

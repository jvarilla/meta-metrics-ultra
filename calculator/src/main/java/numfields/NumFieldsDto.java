package numfields;

public class NumFieldsDto {
    private int totalFields;
    private int privateFields;

    public int getTotalFields() {
        return totalFields;
    }

    public void setTotalFields(int totalFields) {
        this.totalFields = totalFields;
    }

    public int getPrivateFields() {
        return privateFields;
    }

    public void setPrivateFields(int privateFields) {
        this.privateFields = privateFields;
    }

    public int getPackagePrivateFields() {
        return packagePrivateFields;
    }

    public void setPackagePrivateFields(int packagePrivateFields) {
        this.packagePrivateFields = packagePrivateFields;
    }

    public int getProtectedFields() {
        return protectedFields;
    }

    public void setProtectedFields(int protectedFields) {
        this.protectedFields = protectedFields;
    }

    public int getPublicFields() {
        return publicFields;
    }

    public void setPublicFields(int publicFields) {
        this.publicFields = publicFields;
    }

    public int getStaticFields() {
        return staticFields;
    }

    public void setStaticFields(int staticFields) {
        this.staticFields = staticFields;
    }

    private int packagePrivateFields;
    private int protectedFields;
    private int publicFields;
    private int staticFields;


}

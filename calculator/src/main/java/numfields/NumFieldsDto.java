package numfields;

public class NumFieldsDto {
    private int totalFields;
    private int privateFields;
    private int protectedFields;
    private int publicFields;
    private int staticFields;

    public NumFieldsDto(int totalFields, int privateFields, int protectedFields, int publicFields, int staticFields) {
        this.totalFields = totalFields;
        this.privateFields = privateFields;
        this.protectedFields = protectedFields;
        this.publicFields = publicFields;
        this.staticFields = staticFields;
    }

    public NumFieldsDto() {
    }

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

    @Override
    public String toString() {
        return "NumFieldsDto{" +
                "totalNumberOfFields=" + totalFields +
                ", totalPrivateFields=" + privateFields +
                ", totalProtectedFields=" + protectedFields +
                ", totalPublicFields=" + publicFields +
                ", totalStaticFields=" + staticFields +
                '}';
    }
}

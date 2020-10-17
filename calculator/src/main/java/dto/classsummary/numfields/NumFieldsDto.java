package dto.classsummary.numfields;

public class NumFieldsDto {
    private int totalNumberOfFields;
    private int totalPrivateFields;
    private int totalProtectedFields;
    private int totalPublicFields;
    private int totalStaticFields;

    public NumFieldsDto(int totalNumberOfFields, int totalPrivateFields, int totalProtectedFields, int totalPublicFields, int totalStaticFields) {
        this.totalNumberOfFields = totalNumberOfFields;
        this.totalPrivateFields = totalPrivateFields;
        this.totalProtectedFields = totalProtectedFields;
        this.totalPublicFields = totalPublicFields;
        this.totalStaticFields = totalStaticFields;
    }

    public NumFieldsDto() {
    }

    public int getTotalNumberOfFields() {
        return totalNumberOfFields;
    }

    public void setTotalNumberOfFields(int totalNumberOfFields) {
        this.totalNumberOfFields = totalNumberOfFields;
    }

    public int getTotalPrivateFields() {
        return totalPrivateFields;
    }

    public void setTotalPrivateFields(int totalPrivateFields) {
        this.totalPrivateFields = totalPrivateFields;
    }

    public int getTotalProtectedFields() {
        return totalProtectedFields;
    }

    public void setTotalProtectedFields(int totalProtectedFields) {
        this.totalProtectedFields = totalProtectedFields;
    }

    public int getTotalPublicFields() {
        return totalPublicFields;
    }

    public void setTotalPublicFields(int totalPublicFields) {
        this.totalPublicFields = totalPublicFields;
    }

    public int getTotalStaticFields() {
        return totalStaticFields;
    }

    public void setTotalStaticFields(int totalStaticFields) {
        this.totalStaticFields = totalStaticFields;
    }

    @Override
    public String toString() {
        return "NumFieldsDto{" +
                "totalNumberOfFields=" + totalNumberOfFields +
                ", totalPrivateFields=" + totalPrivateFields +
                ", totalProtectedFields=" + totalProtectedFields +
                ", totalPublicFields=" + totalPublicFields +
                ", totalStaticFields=" + totalStaticFields +
                '}';
    }
}

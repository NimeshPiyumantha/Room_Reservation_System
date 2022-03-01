package model;

public class AnnualyIncome {
    private  String colCheck;
    private  double col2022;
    private  double col2023;
    private  double col2024;
    private  double col2025;
    private  double col2026;
    private  double col2027;
    private  double col2028;
    private  double col2029;

    public AnnualyIncome(String colCheck, double col2022, double col2023, double col2024, double col2025, double col2026, double col2027, double col2028, double col2029) {
        this.colCheck = colCheck;
        this.col2022 = col2022;
        this.col2023 = col2023;
        this.col2024 = col2024;
        this.col2025 = col2025;
        this.col2026 = col2026;
        this.col2027 = col2027;
        this.col2028 = col2028;
        this.col2029 = col2029;
    }

    public String getColCheck() {
        return colCheck;
    }

    public void setColCheck(String colCheck) {
        this.colCheck = colCheck;
    }

    public double getCol2022() {
        return col2022;
    }

    public void setCol2022(double col2022) {
        this.col2022 = col2022;
    }

    public double getCol2023() {
        return col2023;
    }

    public void setCol2023(double col2023) {
        this.col2023 = col2023;
    }

    public double getCol2024() {
        return col2024;
    }

    public void setCol2024(double col2024) {
        this.col2024 = col2024;
    }

    public double getCol2025() {
        return col2025;
    }

    public void setCol2025(double col2025) {
        this.col2025 = col2025;
    }

    public double getCol2026() {
        return col2026;
    }

    public void setCol2026(double col2026) {
        this.col2026 = col2026;
    }

    public double getCol2027() {
        return col2027;
    }

    public void setCol2027(double col2027) {
        this.col2027 = col2027;
    }

    public double getCol2028() {
        return col2028;
    }

    public void setCol2028(double col2028) {
        this.col2028 = col2028;
    }

    public double getCol2029() {
        return col2029;
    }

    public void setCol2029(double col2029) {
        this.col2029 = col2029;
    }

    @Override
    public String toString() {
        return "AnnualyIncome{" +
                "colCheck='" + colCheck + '\'' +
                ", col2022=" + col2022 +
                ", col2023=" + col2023 +
                ", col2024=" + col2024 +
                ", col2025=" + col2025 +
                ", col2026=" + col2026 +
                ", col2027=" + col2027 +
                ", col2028=" + col2028 +
                ", col2029=" + col2029 +
                '}';
    }
}

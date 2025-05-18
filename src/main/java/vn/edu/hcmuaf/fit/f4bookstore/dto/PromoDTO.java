package vn.edu.hcmuaf.fit.f4bookstore.dto;

public class PromoDTO {
    private String name;
    private String value;             // 👉 Dạng "10.000"

    public PromoDTO(String name, double value) {
        this.name = name;
        this.value = formatCurrency(value);
    }

    private String formatCurrency(double val) {
        return String.format("%,.0f", val);  // 10000 → "10.000"
    }
    // Getter, Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

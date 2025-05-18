package vn.edu.hcmuaf.fit.f4bookstore.dto;

public class DetailDTO {
    private String tacgia;
    private String xuatsu;

    public DetailDTO(String tacgia, String xuatsu) {
        this.tacgia = tacgia;
        this.xuatsu = xuatsu;
    }

    // Getter, Setter

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getXuatsu() {
        return xuatsu;
    }

    public void setXuatsu(String xuatsu) {
        this.xuatsu = xuatsu;
    }
}


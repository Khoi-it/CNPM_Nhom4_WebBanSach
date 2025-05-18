package vn.edu.hcmuaf.fit.f4bookstore.dto;

import vn.edu.hcmuaf.fit.f4bookstore.model.Product;

public class ProductDTO {
    private int id;
    private String name;
    private String company = "";
    private String img;
    private String price;
    private int star;
    private int rateCount;
    private String masp;
    private PromoDTO promo;
    private DetailDTO detail;

    // Getter, Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public PromoDTO getPromo() {
        return promo;
    }

    public void setPromo(PromoDTO promo) {
        this.promo = promo;
    }

    public DetailDTO getDetail() {
        return detail;
    }

    public void setDetail(DetailDTO detail) {
        this.detail = detail;
    }

    public static ProductDTO fromProduct(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        return dto;
    }
}

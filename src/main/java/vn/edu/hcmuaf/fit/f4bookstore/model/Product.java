package vn.edu.hcmuaf.fit.f4bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String masp;  // mã sản phẩm
    private String name;
    private String company;
    private String img;
    private Double price;
    private Integer star;
    private Integer rateCount;
    private String author;
    private String origin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promo_id")
    private Promo promo;

    // Constructors
    public Product() {}

    public Product(int id, String masp, String name, String company, String img, Double price, Integer star, Integer rateCount, String author, String origin, Promo promo) {
        this.id = id;
        this.masp = masp;
        this.name = name;
        this.company = company;
        this.img = img;
        this.price = price;
        this.star = star;
        this.rateCount = rateCount;
        this.author = author;
        this.origin = origin;
        this.promo = promo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMasp() { return masp; }
    public void setMasp(String masp) { this.masp = masp; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStar() { return star; }
    public void setStar(Integer star) { this.star = star; }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getRateCount() { return rateCount; }
    public void setRateCount(Integer rateCount) { this.rateCount = rateCount; }

    public Promo getPromo() { return promo; }
    public void setPromo(Promo promo) { this.promo = promo; }
}

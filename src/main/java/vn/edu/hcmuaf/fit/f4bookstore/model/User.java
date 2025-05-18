package vn.edu.hcmuaf.fit.f4bookstore.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String pass;
    private String ho;
    private String ten;
    private String email;

    // Mối quan hệ OneToMany với Product (giả sử user sở hữu nhiều sản phẩm)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")  // foreign key trong bảng products
    private List<Product> products;

    // Mối quan hệ với đơn hàng (Order) - bạn cần tạo Entity Order riêng nhé
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")  // foreign key trong bảng orders
    private List<Order> donhang;

    // Constructors
    public User() {}

    public User(String username, String pass, String ho, String ten, String email, List<Product> products, List<Order> donhang) {
        this.username = username;
        this.pass = pass;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.products = products;
        this.donhang = donhang;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public List<Order> getDonhang() { return donhang; }
    public void setDonhang(List<Order> donhang) { this.donhang = donhang; }
}

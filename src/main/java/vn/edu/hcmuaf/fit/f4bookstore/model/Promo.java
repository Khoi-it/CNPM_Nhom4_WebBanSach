package vn.edu.hcmuaf.fit.f4bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "promos")
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // giamgia, tragop, giaReOnline, moiramat

    private Double value;

    // Constructors
    public Promo() {}

    public Promo(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
}

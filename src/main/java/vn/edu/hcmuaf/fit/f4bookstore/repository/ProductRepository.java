package vn.edu.hcmuaf.fit.f4bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmuaf.fit.f4bookstore.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByMasp(String masp);
    List<Product> findByStar(int star);
    List<Product> findByPromo_NameContaining(String keyword);
    List<Product> findByPriceLessThanEqual(double price);
}

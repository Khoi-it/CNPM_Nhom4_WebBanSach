package vn.edu.hcmuaf.fit.f4bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.f4bookstore.dto.ProductDTO;
import vn.edu.hcmuaf.fit.f4bookstore.model.Product;
import vn.edu.hcmuaf.fit.f4bookstore.repository.ProductRepository;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductDTO> getAllProductDTOs() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Product getProductByMasp(String masp) {
        return productRepository.findByMasp(masp).orElse(null);
    }

    public List<Product> getProductsByStar(int star) {
        return productRepository.findByStar(star);
    }

    public List<Product> getProductsByPromo(String promo) {
        return productRepository.findByPromo_NameContaining(promo);
    }

    public List<Product> getProductsByPriceLessThan(double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }

    public List<ProductDTO> filterProducts(String search, String price, String promo, String star, String sort) {
        List<Product> filtered = productRepository.findAll(); // hoặc custom query sau

        if (search != null && !search.isEmpty()) {
            filtered = filtered.stream()
                    .filter(p -> p.getName().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (price != null && price.contains("-")) {
            String[] range = price.split("-");
            double min = Double.parseDouble(range[0]);
            double max = Double.parseDouble(range[1]);
            filtered = filtered.stream()
                    .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                    .collect(Collectors.toList());
        }

        if (promo != null) {
            filtered = filtered.stream()
                    .filter(p -> p.getPromo() != null && p.getPromo().getName().equalsIgnoreCase(promo))
                    .collect(Collectors.toList());
        }

        if (star != null) {
            int starInt = Integer.parseInt(star);
            filtered = filtered.stream()
                    .filter(p -> p.getStar() >= starInt)
                    .collect(Collectors.toList());
        }

        if (sort != null) {
            String[] parts = sort.split("-");
            String field = parts[0];
            boolean descending = parts.length > 1 && parts[1].equals("decrease");

            Comparator<Product> comparator = switch (field) {
                case "price" -> Comparator.comparing(Product::getPrice);
                case "star" -> Comparator.comparing(Product::getStar);
                case "rateCount" -> Comparator.comparing(Product::getRateCount);
                case "name" -> Comparator.comparing(Product::getName, String::compareToIgnoreCase);
                default -> null;
            };

            if (comparator != null) {
                if (descending) comparator = comparator.reversed();
                filtered.sort(comparator);
            }
        }

        return filtered.stream().map(ProductDTO::fromProduct).collect(Collectors.toList());
    }


}


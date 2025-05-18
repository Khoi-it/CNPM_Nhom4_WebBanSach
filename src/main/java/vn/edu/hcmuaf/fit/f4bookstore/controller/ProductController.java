package vn.edu.hcmuaf.fit.f4bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.f4bookstore.dto.ProductDTO;
import vn.edu.hcmuaf.fit.f4bookstore.model.Product;
import vn.edu.hcmuaf.fit.f4bookstore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Cho phép gọi từ frontend JS
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductDTO> getProducts() {
        return productService.getAllProductDTOs();
    }


    @GetMapping("/star/{star}")
    public List<Product> getByStar(@PathVariable int star) {
        return productService.getProductsByStar(star);
    }

    @GetMapping("/promo/{name}")
    public List<Product> getByPromo(@PathVariable String name) {
        return productService.getProductsByPromo(name);
    }

    @GetMapping("/max-price/{price}")
    public List<Product> getByMaxPrice(@PathVariable double price) {
        return productService.getProductsByPriceLessThan(price);
    }

    @GetMapping("/filter")
    public List<ProductDTO> filterProducts(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String promo,
            @RequestParam(required = false) String star,
            @RequestParam(required = false) String sort
    ) {
        return productService.filterProducts(search, price, promo, star, sort);
    }
}

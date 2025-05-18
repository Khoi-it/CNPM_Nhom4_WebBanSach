package vn.edu.hcmuaf.fit.f4bookstore.service;

import vn.edu.hcmuaf.fit.f4bookstore.dto.DetailDTO;
import vn.edu.hcmuaf.fit.f4bookstore.dto.ProductDTO;
import vn.edu.hcmuaf.fit.f4bookstore.dto.PromoDTO;
import vn.edu.hcmuaf.fit.f4bookstore.model.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.setMasp(p.getMasp());
        dto.setName(p.getName());
        dto.setCompany(""); // luôn rỗng
        dto.setImg(p.getImg());
        dto.setPrice(formatCurrency(p.getPrice()));
        dto.setStar(p.getStar());
        dto.setRateCount(p.getRateCount() != null ? p.getRateCount() : 0);

        if (p.getPromo() != null) {
            dto.setPromo(new PromoDTO(p.getPromo().getName(), p.getPromo().getValue()));
        }

        dto.setDetail(new DetailDTO(p.getAuthor(), p.getOrigin()));
        return dto;
    }

    private static String formatCurrency(double val) {
        return String.format("%,.0f", val);
    }
}

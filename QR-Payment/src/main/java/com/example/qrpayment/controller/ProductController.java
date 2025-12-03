package com.example.qrpayment.controller;

import com.example.qrpayment.entity.Product;
import com.example.qrpayment.service.ProductService;
import com.example.qrpayment.service.QRService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final QRService qrService;

    public ProductController(ProductService productService, QRService qrService) {
        this.productService = productService;
        this.qrService = qrService;
    }

    @GetMapping
    public List<Product> getAll() { return productService.getAll(); }

    @GetMapping("/{id}/qrcode")
    public Map<String, String> generateQR(@PathVariable Long id) {
        Product p = productService.getById(id);
        if (p == null) throw new RuntimeException("Product not found");
        String upi = "upi://pay?pa=5085461070679296@ybl&pn=Mohammad Aakil&am=" + p.getPrice() + "&tn=" + p.getName();
        String qr = qrService.generateUPIQR(upi);
        return Map.of("qrCode", qr, "upi", upi);
    }
}

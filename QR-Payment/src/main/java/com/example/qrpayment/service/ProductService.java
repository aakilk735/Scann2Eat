package com.example.qrpayment.service;

import com.example.qrpayment.entity.Product;
import com.example.qrpayment.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }
    public List<Product> getAll() { return repo.findAll(); }
    public Product getById(Long id) { return repo.findById(id).orElse(null); }
}

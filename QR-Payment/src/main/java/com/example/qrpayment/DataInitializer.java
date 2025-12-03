package com.example.qrpayment;

import com.example.qrpayment.entity.Product;
import com.example.qrpayment.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository repo;

    public DataInitializer(ProductRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            repo.save(new Product("Burgur", 20.0, "/image/burgur.svg"));
            repo.save(new Product("Pizza", 35.0, "/image/pizza.svg"));
            repo.save(new Product("Hot Dog", 25.0, "/image/hotdog.svg"));
            repo.save(new Product("Sandwich", 45.0, "/image/sandwich.svg"));
            repo.save(new Product("Donut", 30.0, "/image/donut.svg"));
            repo.save(new Product("Cake", 100.0, "/image/cake.svg"));
            repo.save(new Product("Fries", 15.0, "/image/fries.svg"));
            repo.save(new Product("Noodles", 50.0, "/image/noodles.svg"));
            repo.save(new Product("Cold Drink", 40.0, "/image/coldrink.svg"));
            repo.save(new Product("Momos", 60.0, "/image/momos.svg"));
        }
    }
}

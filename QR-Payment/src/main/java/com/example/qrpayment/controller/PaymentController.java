package com.example.qrpayment.controller;

import com.example.qrpayment.entity.Transaction;
import com.example.qrpayment.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {

    private final PaymentService service;
    public PaymentController(PaymentService service) { this.service = service; }

    @PostMapping("/store")
    public Transaction store(@RequestBody Transaction t) {
        if (t.getStatus() == null) t.setStatus("SUCCESS");
        return service.save(t);
    }

    @GetMapping("/list")
    public List<Transaction> list() { return service.listAll(); }
}

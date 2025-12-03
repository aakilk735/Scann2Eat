package com.example.qrpayment.service;

import com.example.qrpayment.entity.Transaction;
import com.example.qrpayment.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final TransactionRepository repo;
    public PaymentService(TransactionRepository repo) { this.repo = repo; }
    public Transaction save(Transaction t) { return repo.save(t); }
    public java.util.List<Transaction> listAll() { return repo.findAll(); }
}

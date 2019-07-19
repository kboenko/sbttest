package com.example.sbttest.services;

import com.example.sbttest.entity.Purchase;
import com.example.sbttest.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getList() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.getOne(id);
    }

    public String savePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
        return "success";
    }
}

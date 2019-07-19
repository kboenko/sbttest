package com.example.sbttest.services;

import com.example.sbttest.entity.Product;
import com.example.sbttest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }
}

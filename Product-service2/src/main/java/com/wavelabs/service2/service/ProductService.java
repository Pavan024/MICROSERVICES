package com.wavelabs.service2.service;

import com.wavelabs.service2.entity.Product;
import com.wavelabs.service2.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
    
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

}

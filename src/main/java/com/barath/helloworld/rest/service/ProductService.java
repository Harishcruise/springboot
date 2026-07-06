package com.barath.helloworld.rest.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barath.helloworld.rest.entity.Product;
import com.barath.helloworld.rest.repository.ProductRepository;

import jakarta.inject.Inject;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
    public void save(Product product){
        productRepository.save(product);
    }
    public Optional<Product> update(Long id,Product product){
        return productRepository.update(id,product);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}

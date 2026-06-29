package com.barath.helloworld.rest.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.barath.helloworld.rest.entity.Product;
import com.barath.helloworld.rest.repository.ProductRepository;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
        return productRepository.findById(id);
    }
    public void save(Product product){
        productRepository.save(product);
    }
    public void update(Long id,Product product){
        productRepository.update(id,product);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}

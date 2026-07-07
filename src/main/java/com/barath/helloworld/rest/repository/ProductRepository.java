package com.barath.helloworld.rest.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.barath.helloworld.rest.entity.Product;

@Repository
public class ProductRepository {
        private final JdbcTemplate jdbcTemplate;
        public ProductRepository(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
        public List<Product> findAll(int page, int size){
            String sql = "SELECT id, name, price FROM products LIMIT ? OFFSET ?";
            int offset = page * size;
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class),size,offset);
        }
        public Optional<Product> findById(Long id){
            String sql = "SELECT id, name, price FROM products WHERE id = ?";
            List<Product> products = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class),id);
            Optional<Product> result = products.stream().findFirst();
            return result;
        }
        public void save(Product product){
            String sql = "INSERT INTO products (name,price) VALUES (?,?)";
            jdbcTemplate.update(sql,product.getName(),product.getPrice());
        }
        public Optional<Product> update(Long id, Product product){
            String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
            int rowsAffected = jdbcTemplate.update(sql,product.getName(),product.getPrice(),id);
            if(rowsAffected ==0){
                return Optional.empty();
            }
            return findById(id);

        }
        public void deleteById(Long id){
            String sql ="DELETE FROM products WHERE id = ?";
            jdbcTemplate.update(sql,id);
        }

}

package com.barath.helloworld.rest.repository;
import java.util.List;

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
        public List<Product> findAll(){
            String sql = "SELECT * FROM products";
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class));
        }
        public Product findById(Long id){
            String sql = "SELECT * FROM products WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class),id);
        }
        public void save(Product product){
            String sql = "INSERT INTO products (name,price) VALUES (?,?)";
            jdbcTemplate.update(sql,product.getName(),product.getPrice());
        }
        public void update(Long id, Product product){
            String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
            jdbcTemplate.update(sql,product.getName(),product.getPrice(),id);

        }
        public void deleteById(Long id){
            String sql ="DELETE FROM products WHERE id = ?";
            jdbcTemplate.update(sql,id);
        }

}

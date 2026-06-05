package io.example.com.produtosApi.repositories;

import io.example.com.produtosApi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product , String> {
    List<Product> findByName(String name);
}

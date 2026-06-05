package io.example.com.produtosApi.repositories;

import io.example.com.produtosApi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , String> {}

package io.example.com.produtosApi.controllers;

import io.example.com.produtosApi.models.Product;
import io.example.com.produtosApi.repositories.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        System.out.println("Produto recebido," + product);
        product.setId(UUID.randomUUID().toString());
        productRepository.save(product);
        return product;
    }

}

package io.example.com.produtosApi.controllers;

import io.example.com.produtosApi.models.Product;
import io.example.com.produtosApi.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public List<Product> listProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}/")
    public Product ProductDetail(@PathVariable("id") String id){
        Optional<Product> product = productRepository.findById(id);
        return product.isPresent() ? product.get() : null;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        System.out.println("Produto recebido," + product);
        product.setId(UUID.randomUUID().toString());
        productRepository.save(product);
        return product;
    }

}

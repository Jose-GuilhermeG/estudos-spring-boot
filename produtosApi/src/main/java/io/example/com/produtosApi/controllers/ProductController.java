package io.example.com.produtosApi.controllers;

import io.example.com.produtosApi.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        System.out.println("Produto recebido," + product);
        return product;
    }

}

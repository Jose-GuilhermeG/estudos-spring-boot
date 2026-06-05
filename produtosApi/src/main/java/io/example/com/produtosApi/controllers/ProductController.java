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
    public List<Product> listProduct(@RequestParam(value = "name",required = false) String name){
        return name == null ? productRepository.findAll() : productRepository.findByName(name);
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

    @DeleteMapping("/{id}/")
    public String deleteProduct(@PathVariable("id") String id){
        if (!productExists(id)) return getNotExistMsg(id);
        productRepository.deleteById(id);
        return  "produto apagado";
    }

    @PutMapping("/{id}/")
    public String updateProduct(@PathVariable("id") String id , @RequestBody Product product){
        if (!productExists(id)) return getNotExistMsg(id);
        product.setId(id);
        productRepository.save(product);
        return "produto atualizado";
    }

    private Boolean productExists(String id){
        return productRepository.existsById(id);
    }

    private String getNotExistMsg(String id){
        return String.format("O Produto com o id : '%s' não existe" , id);
    }

}

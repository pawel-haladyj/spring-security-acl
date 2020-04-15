package pl.haladyj.springsecurityacl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.haladyj.springsecurityacl.dao.ProductRepository;
import pl.haladyj.springsecurityacl.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return repository.findById(id).orElse(new Product());
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }


}

package br.com.meli.bootcampspringprodutos.controller;

import br.com.meli.bootcampspringprodutos.entity.Product;
import br.com.meli.bootcampspringprodutos.exception.ProductNotFoundException;
import br.com.meli.bootcampspringprodutos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(repository.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(repository.getById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product, UriComponentsBuilder uriBuilder) {
        try {
            repository.create(product);
            URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (KeyAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> fullUpdate(@PathVariable int id, @RequestBody Product product, UriComponentsBuilder uriBuilder) {
        try {
            repository.update(id, product);
            return ResponseEntity.ok().build();
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id) {
        try {
            repository.delete(id);
            return ResponseEntity.ok().build();
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

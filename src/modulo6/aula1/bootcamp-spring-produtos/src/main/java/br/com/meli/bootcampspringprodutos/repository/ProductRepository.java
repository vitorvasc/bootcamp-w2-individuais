package br.com.meli.bootcampspringprodutos.repository;

import br.com.meli.bootcampspringprodutos.entity.Product;
import br.com.meli.bootcampspringprodutos.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductRepository {

    private static final List<Product> productList = new ArrayList<Product>(
            List.of(
                    new Product(1, "Playstation 5", "Standard Edition", 6999.00),
                    new Product(1, "Xbox Series S", "512GB Branco", 2700.00)
            )
    );

    public List<Product> getList() {
        return productList;
    }

    public Product getById(int id) throws ProductNotFoundException {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Produto " + id + " não encontrado."));
    }

    public void create(Product product) {
        Optional<Product> productOptional = productList.stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst();

        if (productOptional.isEmpty()) {
            productList.add(product);
        } else {
            throw new KeyAlreadyExistsException("Produto com ID " + product.getId() + " já existe.");
        }
    }

    public void update(int id, Product product) throws ProductNotFoundException {
        Product p = this.getById(id);

        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setValue(product.getValue());
    }

    public void delete(int id) throws ProductNotFoundException {
        Product p = this.getById(id);
        productList.remove(p);
    }
}

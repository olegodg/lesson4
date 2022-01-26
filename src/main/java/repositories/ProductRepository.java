package repositories;

import models.Product;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(new Product(1L, "bread", 50.40f),
                new Product(2L, "butter", 250.10f),
                new Product(3L, "salt", 21.00f)
        ));
    }

    public List<Product> productAll() {
        return Collections.unmodifiableList(products);
    }

    public Product productById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void saveProduct(Product product) {
        products.add(product);
    }
}
package services;

import models.Product;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showProductsAll() {
        return productRepository.productAll();
    }

    public Product productById(Long id) {
        return productRepository.productById(id);
    }

    public void productAdd(Product product) {
        productRepository.saveProduct(product);
    }

}

package com.codeforges.ngShop.product;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    public void createProduct() {
        Product product = new Product(
                "test",
                "test",
                "My cool product"

        );

        productRepository.save(product);
    }
}

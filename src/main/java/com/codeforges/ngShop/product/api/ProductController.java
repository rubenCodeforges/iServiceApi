package com.codeforges.ngShop.product.api;

import com.codeforges.common.config.ApiConfig;
import com.codeforges.ngShop.product.Product;
import com.codeforges.ngShop.product.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(ApiConfig.URL + "/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    void createProduct() {
        productService.createProduct();
    }
}

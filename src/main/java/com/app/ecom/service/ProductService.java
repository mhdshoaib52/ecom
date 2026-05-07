package com.app.ecom.service;


import com.app.ecom.dto.ProductRequest;
import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Object createProduct(ProductRequest productRequest) {
        Product product = new Product();
        updateProductFromRequest(product,productRequest);
        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }

    private ProductResponse mapToProductResponse(Product savedProduct) {
        ProductResponse response = new ProductResponse();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setActive(savedProduct.getActive());
        response.setCategory(savedProduct.getCategory());
        response.setStockQuantity(savedProduct.getStockQuantity());
        response.setImageUrl(savedProduct.getImageUrl());
        response.setPrice(savedProduct.getPrice());
        response.setDescription(savedProduct.getDescription());
        return response;
    }

    private void updateProductFromRequest(Product product, ProductRequest productRequest) {

        product.setName(ProductRequest.getName());
        product.setCategory(ProductRequest.getCategory());
        product.setStockQuantity(ProductRequest.getStockQuantity());
        product.setImageUrl(ProductRequest.getImageUrl());
        product.setPrice(ProductRequest.getPrice());
        product.setDescription(ProductRequest.getDescription());
    }
}

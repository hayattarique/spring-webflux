package org.boot.reactive.service;

import lombok.RequiredArgsConstructor;
import org.boot.reactive.dto.ProductResponseDto;
import org.boot.reactive.entities.Product;
import org.boot.reactive.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Flux<ProductResponseDto> findAll() {
        Flux<Product> products = productRepository.findAll();
        return products.map(this::entityToDto);
    }

    @Transactional(readOnly = true)
    public Mono<ProductResponseDto> findById(int id) {

        return productRepository.findById(id).map(this::entityToDto);
    }

    @Transactional
    public Mono<ProductResponseDto> update(Product product) {
        productRepository.findById(product.getProductId());
        product.setProductName("Mac");
        return productRepository.save(product).map(this::entityToDto);
    }

    private ProductResponseDto entityToDto(Product product) {
        return ProductResponseDto.builder().productId(product.getProductId()).price(product.getPrice()).productName(product.getProductName()).productDescription(product.getProductDescription()).category(product.getCategory()).build();
    }
}

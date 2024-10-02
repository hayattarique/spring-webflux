package org.boot.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.boot.reactive.dto.ProductResponseDto;
import org.boot.reactive.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<ProductResponseDto> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/get/{id}")
    public Mono<ProductResponseDto> getProduct(@PathVariable int id) {

        return productService.findById(id);
    }
}

package ru.gb.api.product.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.api.product.dto.ProductManufacturerDto;

import java.util.List;


public interface ProductGateway {

    @GetMapping
    List<ProductDto> getProductList();

    @GetMapping("/{productId}")
    ResponseEntity<?> getProduct(@PathVariable("productId") Long id);

    @GetMapping("/info")
    public List<ProductManufacturerDto> getInfoProductList();

    @PostMapping
    ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto);

    @PutMapping("/{productId}")
    ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id,
                                   @Validated @RequestBody ProductDto productDto);

    @DeleteMapping("/{productId}")
    void deleteById(@PathVariable("productId") Long id);
}

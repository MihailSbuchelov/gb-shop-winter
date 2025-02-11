package ru.gb.external.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.product.api.ProductGateway;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.api.product.dto.ProductManufacturerDto;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductGateway productService;

    @GetMapping
    public List<ProductDto> getProductList() {
        return productService.getProductList();
    }

    @GetMapping("/info")
    public List<ProductManufacturerDto> getInfoProductList() {
        return productService.getInfoProductList();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") Long id) {
        if (id != null) {
            if (productService.getProduct(id) != null) {
                return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto) {
        productService.handlePost(productDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/product/" + productService.getProduct(productDto.getId())));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id, @Validated @RequestBody ProductDto productDto) {
        productDto.setId(id);
        productService.handleUpdate(id,productDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("productId") Long id) {
        productService.deleteById(id);
    }
}

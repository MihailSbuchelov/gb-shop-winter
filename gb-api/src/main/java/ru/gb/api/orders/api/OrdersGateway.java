package ru.gb.api.orders.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.orders.dto.OrdersDto;

public interface OrdersGateway {
    @GetMapping("/{ordersId}")
    ResponseEntity<?> getOrders(@PathVariable("ordersId") Long id);

    @PostMapping
    ResponseEntity<?> handlePost(@Validated @RequestBody OrdersDto ordersDto);

    @PutMapping("/{ordersId}")
    ResponseEntity<?> handleUpdate(@PathVariable("ordersId") Long id,
                                   @Validated @RequestBody OrdersDto ordersDto);

    @DeleteMapping("/{ordersId}")
    void deleteById(@PathVariable("ordersId") Long id);
}
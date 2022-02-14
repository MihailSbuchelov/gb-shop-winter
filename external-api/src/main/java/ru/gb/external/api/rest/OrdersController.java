package ru.gb.external.api.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.orders.api.OrdersGateway;
import ru.gb.api.orders.dto.OrdersDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private OrdersGateway ordersGateway;

    @GetMapping("/{ordersId}")
    public ResponseEntity<?> getCategory(@PathVariable("ordersId") Long id) {
        return ordersGateway.getOrders(id);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Validated @RequestBody OrdersDto ordersDto) {
        ordersGateway.handlePost(ordersDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{ordersId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("ordersId") Long id,
                                          @Validated @RequestBody OrdersDto ordersDto) {
        ordersDto.setOrdersId(id);
        ordersGateway.handleUpdate(id, ordersDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{ordersId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("ordersId") Long id) {
        ordersGateway.deleteById(id);
    }

}
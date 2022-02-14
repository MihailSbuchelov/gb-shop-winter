package ru.gb.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.api.orders.dto.OrdersDto;
import ru.gb.service.OrdersService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @GetMapping("/{ordersId}")
    public ResponseEntity<?> getCategory(@PathVariable("ordersId") Long id) {

        return new ResponseEntity<>(ordersService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Validated @RequestBody OrdersDto ordersDto) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{ordersId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("ordersId") Long id,
                                          @Validated @RequestBody OrdersDto ordersDto) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{ordersId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("ordersId") Long id) {
        ordersService.deleteById(id);
    }
}
package ru.gb.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.gb.common.exception.mapper.NoSuchCategoryException;
import ru.gb.common.exception.mapper.NoSuchManufacturerException;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({NoSuchCategoryException.class, NoSuchManufacturerException.class})
    public ResponseEntity<?> validationErrorHandler(NoSuchElementException e) {
        log.trace(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}

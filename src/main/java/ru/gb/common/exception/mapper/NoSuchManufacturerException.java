package ru.gb.common.exception.mapper;

import java.util.NoSuchElementException;

public class NoSuchManufacturerException extends NoSuchElementException {
    public NoSuchManufacturerException(String s) {
        super("There isn't manufacturer with name: '" + s + "'; Before create new product, you should add new manufacturer!");
    }
}
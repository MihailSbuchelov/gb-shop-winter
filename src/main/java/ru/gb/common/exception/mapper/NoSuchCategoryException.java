package ru.gb.common.exception.mapper;

import java.util.NoSuchElementException;

public class NoSuchCategoryException extends NoSuchElementException {
    public NoSuchCategoryException(String s) {
        super("There isn't category with name: '" + s + "'; Before create new product, you should add new category!");
    }
}
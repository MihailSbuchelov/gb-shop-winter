package ru.gb.web.dto.mapper;

import org.mapstruct.*;
import ru.gb.entity.Category;
import ru.gb.entity.Product;
import ru.gb.web.dto.CategoryDto;
import ru.gb.web.dto.ProductManufacturerDto;

@Mapper(uses = ManufacturerMapper.class)
public interface CategoryMapper {
    @Mapping(source = "categoryId", target = "id")
    Category toCategory(CategoryDto categoryDto);

    @Mapping(source = "id", target = "categoryId")
    CategoryDto toCategoryDto(Category category);
}
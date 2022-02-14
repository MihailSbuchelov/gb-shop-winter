package ru.gb.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.api.orders.dto.OrdersDto;
import ru.gb.dao.CategoryDao;
import ru.gb.dao.ManufacturerDao;
import ru.gb.entity.Orders;

@Mapper(uses = {ProductMapper.class, ManufacturerMapper.class})
public interface OrdersMapper {
    @Mapping(source = "ordersId", target = "id")
    Orders toOrders(OrdersDto ordersDto, @Context ManufacturerDao manufacturerDao, @Context CategoryDao categoryDao);

    @Mapping(source = "id", target = "ordersId")
    OrdersDto toOrdersDto(Orders orders);
}

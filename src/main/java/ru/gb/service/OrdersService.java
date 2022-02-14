package ru.gb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.orders.dto.OrdersDto;
import ru.gb.dao.CategoryDao;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OrdersDao;
import ru.gb.entity.Category;
import ru.gb.entity.Orders;
import ru.gb.web.dto.mapper.OrdersMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

    private final OrdersDao ordersDao;
    private final OrdersMapper ordersMapper;
    private final CategoryDao categoryDao;
    private final ManufacturerDao manufacturerDao;

    @Transactional
    public OrdersDto save(final OrdersDto ordersDto) {
        Orders orders = ordersMapper.toOrders(ordersDto, manufacturerDao, categoryDao);
        if (orders.getId() != null) {
            ordersDao.findById(orders.getId()).ifPresent(
                    (p) -> orders.setVersion(p.getVersion())
            );
        }
        return ordersMapper.toOrdersDto(ordersDao.save(orders));
    }

    @Transactional(readOnly = true)
    public OrdersDto findById(Long id) {
        return ordersMapper.toOrdersDto(ordersDao.findById(id).orElse(null));
    }


    public List<OrdersDto> findAll() {
        return ordersDao.findAll().stream().map(ordersMapper::toOrdersDto).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            ordersDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
        }
    }

}

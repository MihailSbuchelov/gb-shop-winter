package ru.gb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Orders;

import java.util.Optional;

public interface OrdersDao extends JpaRepository<Orders, Long> {
}

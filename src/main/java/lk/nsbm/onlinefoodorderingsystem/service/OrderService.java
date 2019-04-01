package lk.nsbm.onlinefoodorderingsystem.service;

import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;

import java.util.List;

public interface OrderService {
    public OrderDto addOrder(OrderDto orderDto );
    public List<OrderDto> getOrders();
    public List<OrderDto> getSelectedOrders(int id);
}

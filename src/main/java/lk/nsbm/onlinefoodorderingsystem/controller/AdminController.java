package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;
import lk.nsbm.onlinefoodorderingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrderList(){
        return orderService.getOrders();
    }
}

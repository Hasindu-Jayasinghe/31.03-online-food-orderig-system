package lk.nsbm.onlinefoodorderingsystem.controller;

import lk.nsbm.onlinefoodorderingsystem.dto.ContactDetailsDto;
import lk.nsbm.onlinefoodorderingsystem.dto.OrderDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserCredentialDto;
import lk.nsbm.onlinefoodorderingsystem.dto.UserDto;
import lk.nsbm.onlinefoodorderingsystem.entity.UserCredential;
import lk.nsbm.onlinefoodorderingsystem.service.OrderService;
import lk.nsbm.onlinefoodorderingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/register")
    public boolean registerUser(@RequestBody UserCredentialDto userCredentialDto) {
        return userService.registerUser(userCredentialDto);
    }

    @PostMapping(value = "/add-order",consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addOrder(@RequestBody OrderDto orderDto ){
        return orderService.addOrder(orderDto);
    }

    @GetMapping(value = "/get-comments")
    public List<ContactDetailsDto> getUserComments(){
        return userService.getUserComments();
    }

    @GetMapping(value = "/get-order/{id}")
    public List<OrderDto> getOrders(@PathVariable int id){
        return orderService.getSelectedOrders(id);
    }
}

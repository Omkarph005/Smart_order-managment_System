
package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable int id) {
        return service.getOrder(id);
    }

    @GetMapping
    public Collection<Order> getAll() {
        return service.getAllOrders();
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable int id, @RequestBody Order order) {
        return service.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteOrder(id);
    }
}

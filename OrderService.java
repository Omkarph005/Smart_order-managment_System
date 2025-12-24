
package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    private final Map<Integer, Order> orderStore = new ConcurrentHashMap<>();

    public Order createOrder(Order order) {
        orderStore.put(order.getId(), order);
        return order;
    }

    public Order getOrder(int id) {
        Order order = orderStore.get(id);
        if (order == null) {
            throw new OrderNotFoundException("Order not found: " + id);
        }
        return order;
    }

    public Collection<Order> getAllOrders() {
        return orderStore.values();
    }

    public Order updateOrder(int id, Order updated) {
        if (!orderStore.containsKey(id)) {
            throw new OrderNotFoundException("Order not found: " + id);
        }
        orderStore.put(id, updated);
        return updated;
    }

    public void deleteOrder(int id) {
        orderStore.remove(id);
    }
}

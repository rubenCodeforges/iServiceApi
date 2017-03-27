package com.manager.api.order;

import com.manager.api.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService implements CrudService<Order> {

    private OrderRepository orderRepository;

    @Autowired
    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Collection<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }
}

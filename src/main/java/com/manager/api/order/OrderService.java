package com.manager.api.order;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ModelMapper modelMapper = new ModelMapper();

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Collection<Order> getAll() {
        return orderRepository.findAll();
    }

    Order findById(Long id) throws OrderNotFoundException {
        Order order = orderRepository.findOne(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        return order;
    }

    public void create(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order = orderRepository.save(order);
        modelMapper.map(order, OrderDto.class);
    }

    void update(Order order) {
        orderRepository.save(order);
    }

    void delete(Long id) {
        orderRepository.delete(id);
    }
}

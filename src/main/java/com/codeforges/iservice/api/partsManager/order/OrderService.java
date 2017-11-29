package com.codeforges.iservice.api.partsManager.order;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Collection<OrderDto> getAll() {
        Collection<Order> orders = orderRepository.findAll();
        return OrderMapper.mapCollectionToDto(orders);
    }

    OrderDto findById(Long id) throws OrderNotFoundException {
        Order order = orderRepository.findOne(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        return OrderMapper.mapToDto(order);
    }

    public void create(OrderCreateDto orderCreateDto) {
        orderRepository.save(OrderMapper.mapCreateDtoToEntity(orderCreateDto));
    }

    OrderDto update(Order order) {
        orderRepository.save(order);
        return OrderMapper.mapToDto(order);
    }

    void delete(Long id) {
        orderRepository.delete(id);
    }
}

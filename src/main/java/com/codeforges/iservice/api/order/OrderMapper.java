package com.codeforges.iservice.api.order;

import com.codeforges.iservice.api.item.Item;
import com.codeforges.iservice.api.item.ItemMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class OrderMapper {
    private OrderMapper() {
    }

    public static OrderDto mapToDto(Order order) {
        if (order == null) {
            return null;
        }

        return new OrderDto(
                order.getId(),
                order.getTitle(),
                order.getState(),
                order.getCreatedAt(),
                ItemMapper.mapCollectionToDto(order.getItems()),
                order.getDescription()
        );
    }

    public static Collection<OrderDto> mapCollectionToDto(Collection<Order> orders) {
        Collection<Order> test = orders;
        if (orders == null) {
            return null;
        }
        Collection<OrderDto> test2 = orders.stream().map(OrderMapper::mapToDto).collect(Collectors.toList());
        return test2;
    }

    public static Order mapDtoToEntity(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        if (orderDto.getId() != null) {
            return new Order(
                    orderDto.getId(),
                    orderDto.getTitle(),
                    orderDto.getState(),
                    orderDto.getCreatedAt(),
                    ItemMapper.mapDtoCollectionToEntity(orderDto.getItems())
            );
        }
        return new Order(orderDto.getTitle());
    }

    public static Order mapCreateDtoToEntity(OrderCreateDto createDto) {
        if (createDto == null) {
            return null;
        }

        Collection<Item> items = ItemMapper.mapDtoCollectionToEntity(createDto.getItems());

        return new Order(
                createDto.getTitle(),
                items
        );
    }

    public static Collection<Order> mapDtoCollectionToEntity(Collection<OrderDto> orderDtos) {
        if (orderDtos == null) {
            return null;
        }
        return orderDtos.stream().map(OrderMapper::mapDtoToEntity).collect(Collectors.toList());
    }
}

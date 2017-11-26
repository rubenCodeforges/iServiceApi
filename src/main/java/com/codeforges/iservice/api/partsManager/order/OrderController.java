package com.codeforges.iservice.api.partsManager.order;

import com.codeforges.common.config.ApiConfig;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(ApiConfig.URL + "/orders")

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<OrderDto> getAll() {
        return orderService.getAll();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public OrderDto findById(@PathVariable Long orderId) throws OrderNotFoundException {
        return orderService.findById(orderId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody OrderCreateDto order) {
        orderService.create(order);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public OrderDto update(@Valid @RequestBody Order order) {
        return orderService.update(order);
    }

    @RequestMapping(value = "/{orderId}/delete", method = RequestMethod.GET)
    public void delete(@Valid @PathVariable Long orderId) {
        orderService.delete(orderId);
    }

}

package com.manager.api.order;

import com.manager.api.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(Api.URL + "/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Order> getAll() {
        return orderService.getAll();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Order findById(@PathVariable Long orderId) throws OrderNotFoundException {
        return orderService.findById(orderId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody OrderDto order) {
        orderService.create(order);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Order order) {
        orderService.update(order);
    }

    @RequestMapping(value = "/{orderId}/delete", method = RequestMethod.GET)
    public void delete(@Valid @PathVariable Long orderId) {
        orderService.delete(orderId);
    }

}

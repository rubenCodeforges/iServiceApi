package com.manager.api.order;

import com.manager.api.Api;
import com.manager.api.internal.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(Api.URL + "/orders")
public class OrderController implements CrudController<Order>{

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Order> getAll() {
        return orderService.getAll();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Order findById(@PathVariable Long orderId) {
        return orderService.findById(orderId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody Order order) {
        orderService.create(order);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Order order) {
        orderService.update(order);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public void delete(@Valid @PathVariable Long orderId) {
        orderService.delete(orderId);
    }

}

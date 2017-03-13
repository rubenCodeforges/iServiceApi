package com.manager.api.order;

import com.manager.api.Api;
import com.manager.api.internal.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Api.URL + "/orders")
public class OrderController implements CrudController<Order>{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Order findOne(@PathVariable String orderId) {
        return orderRepository.findOne(orderId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody Order order) {
        orderRepository.insert(order);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Order order) {
        orderRepository.save(order);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public void delete(@Valid @PathVariable String orderId) {
        orderRepository.delete(orderRepository.findOne(orderId));
    }

}

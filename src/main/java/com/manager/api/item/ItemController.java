package com.manager.api.item;

import com.manager.api.Api;
import com.manager.api.internal.CrudController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(Api.URL + "/items")
public class ItemController implements CrudController<Item>{

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Item> getAll() {
        return itemService.getAll();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "order/{orderId}")
//    public Collection<Item> getAllByOrderId(@Valid @PathVariable Long orderId) {
//        return itemService.findByOrderId(orderId);
//    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    public Item findById(@Valid @PathVariable Long itemId) throws ItemNotFoundException {
        return itemService.findById(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody Item item) {
        itemService.create(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Item item) {
        itemService.update(item);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public void delete(@Valid @PathVariable Long itemId) {
        itemService.delete(itemId);
    }
}

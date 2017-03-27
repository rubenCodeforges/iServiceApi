package com.manager.api.item;

import com.manager.api.Api;
import com.manager.api.internal.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(Api.URL + "/items")
public class ItemController implements CrudController<Item>{

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Item> getAll() {
        return itemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "order/{orderId}")
    public Collection<Item> getAllByOrderId(@Valid @PathVariable Long orderId) {
        return itemRepository.findByOrderId(orderId);
    }


    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    public Item findOne(@Valid @PathVariable Long itemId) {
        return itemRepository.findOne(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody Item item) {
        itemRepository.save(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Item item) {
        itemRepository.save(item);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public void delete(@Valid @PathVariable Long itemId) {
        itemRepository.delete(itemRepository.findOne(itemId));
    }
}

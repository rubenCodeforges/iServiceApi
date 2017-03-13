package com.manager.api.item;

import com.manager.api.Api;
import com.manager.api.internal.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Api.URL + "/items")
public class ItemController implements CrudController<Item>{

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    public Item findOne(@Valid @PathVariable String itemId) {
        return itemRepository.findOne(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Valid @RequestBody Item item) {
        itemRepository.insert(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Item item) {
        itemRepository.save(item);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public void delete(@Valid @PathVariable String itemId) {
        itemRepository.delete(itemRepository.findOne(itemId));
    }
}

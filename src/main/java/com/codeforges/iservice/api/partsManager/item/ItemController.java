package com.codeforges.iservice.api.partsManager.item;

import com.codeforges.iservice.api.config.ApiConfig;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(ApiConfig.URL + "/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ItemDto> getAll(@RequestParam(value = "search", required = false) String search) {
        return itemService.getAll(search);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public ItemDto findById(@Valid @PathVariable Long itemId) throws ItemNotFoundException {
        return itemService.findById(itemId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item create(@Valid @RequestBody Item item) {
        return itemService.create(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody ItemDto item) {
        itemService.update(item);
    }

    @RequestMapping(value = "/{itemId}/delete", method = RequestMethod.GET)
    public void delete(@Valid @PathVariable Long itemId) {
        itemService.delete(itemId);
    }
}

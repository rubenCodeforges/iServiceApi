package com.manager.api.item;


import com.manager.api.internal.CrudService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService implements CrudService<Item> {

    private ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    Collection<Item> findByOrderId(Long orderId) {
        return itemRepository.findByOrders_Id(orderId);
    }

    @Override
    public Collection<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(id);
    }
}

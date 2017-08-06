package com.manager.api.item;


import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Collection<ItemDto> getAll(String search) {
        Collection<Item> items;

        if(search != null){
            items = itemRepository.findByTitleContaining(search);
        }else {
            items = itemRepository.findAll();
        }

        return ItemMapper.mapCollectionToDto(items);
    }


    ItemDto findById(Long id) throws ItemNotFoundException {
        Item item = itemRepository.findOne(id);
        if (item == null) {
            throw new ItemNotFoundException();
        }

        return ItemMapper.mapToDto(item);
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    void update(ItemDto itemDto) {
        Item item = ItemMapper.mapToEntity(itemDto);
        itemRepository.save(item);
    }

    void delete(Long id) {
        itemRepository.delete(id);
    }
}

package com.manager.api.item;


import com.manager.api.image.ImageMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class ItemMapper {
    private ItemMapper() {
    }

    public static ItemDto mapToDto(Item item) {
        if (item == null) {
            return null;
        }

        return new ItemDto(
                item.getId(),
                item.getTitle(),
                item.getDescription(),
                item.getPrice(),
                item.getCurrency(),
                ImageMapper.mapCollectionToDto(item.getImages())
        );
    }

    public static Item mapToEntity(ItemDto itemDto) {
        if (itemDto == null) {
            return null;
        }

        return new Item(
                itemDto.getTitle(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getCurrency(),
                ImageMapper.mapDtoCollectionToEntity(itemDto.getImages())
        );
    }

    public static Collection<ItemDto> mapCollectionToDto(Collection<Item> items) {
        if (items == null) {
            return null;
        }
        return items.stream().map(ItemMapper::mapToDto).collect(Collectors.toList());
    }

    public static Collection<Item> mapDtoCollectionToEntity(Collection<ItemDto> itemDtos) {
        if (itemDtos == null) {
            return null;
        }
        return itemDtos.stream().map(ItemMapper::mapToEntity).collect(Collectors.toList());
    }
}


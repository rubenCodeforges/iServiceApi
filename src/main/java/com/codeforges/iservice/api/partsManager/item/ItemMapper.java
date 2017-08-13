package com.codeforges.iservice.api.partsManager.item;

import com.codeforges.iservice.api.partsManager.image.ImageMapper;

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

        if (isQuickAddItem(itemDto)) {
            return createItemFromOrder(itemDto);
        }


        return createNewItemWithImages(itemDto);
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

    private static boolean isQuickAddItem(ItemDto itemDto) {
        return itemDto.getId() != null && itemDto.getImages() == null;
    }

    private static Item createItemFromOrder(ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getTitle()
        );
    }

    private static Item createNewItemWithImages(ItemDto itemDto) {
        if (itemDto.getId() != null) {
            return new Item(
                    itemDto.getId(),
                    itemDto.getTitle(),
                    itemDto.getDescription(),
                    itemDto.getPrice(),
                    itemDto.getCurrency(),
                    ImageMapper.mapDtoCollectionToEntity(itemDto.getImages())
            );
        }
        return new Item(
                itemDto.getTitle(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getCurrency(),
                ImageMapper.mapDtoCollectionToEntity(itemDto.getImages())
        );
    }

}


package com.manager.api.item;


import com.manager.api.internal.FileUploadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Collection;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private FileUploadService fileUploadService;
    private ModelMapper modelMapper = new ModelMapper();

    ItemService(ItemRepository itemRepository,
                FileUploadService fileUploadService) {
        this.itemRepository = itemRepository;
        this.fileUploadService = fileUploadService;
    }

    public Collection<ItemDto> getAll() {
        Type listType = new TypeToken<Collection<ItemDto>>() {
        }.getType();
        return modelMapper.map(itemRepository.findAll(), listType);
    }


    ItemDto findById(Long id) throws ItemNotFoundException {
        Item item = itemRepository.findOne(id);
        if (item == null) {
            throw new ItemNotFoundException();
        }
        return modelMapper.map(itemRepository.findOne(id), ItemDto.class);
    }

    public ItemDto create(CreateItemDto itemDto) {
        Item item = modelMapper.map(itemDto, Item.class);
        item = itemRepository.save(item);
        return modelMapper.map(item, ItemDto.class);
    }


    void update(ItemDto item) {
        itemRepository.save(modelMapper.map(item, Item.class));
    }

    void delete(Long id) {
        itemRepository.delete(id);
    }
}

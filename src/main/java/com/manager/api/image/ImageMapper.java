package com.manager.api.image;

import java.util.Collection;
import java.util.stream.Collectors;

public class ImageMapper {
    private ImageMapper() {
    }

    public static ImageDto mapToDto(Image image) {
        if (image == null) {
            return null;
        }

        return new ImageDto(image.getId());
    }

    public static Image mapToEntity(ImageDto imageDto) {
        if (imageDto == null) {
            return null;
        }

        return new Image(imageDto.getId());
    }

    public static Collection<ImageDto> mapCollectionToDto(Collection<Image> images) {
        if (images == null) {
            return null;
        }

        return images.stream().map(ImageMapper::mapToDto).collect(Collectors.toList());
    }

    public static Collection<Image> mapDtoCollectionToEntity(Collection<ImageDto> imageDtos) {
        if (imageDtos == null) {
            return null;
        }

        return imageDtos.stream().map(ImageMapper::mapToEntity).collect(Collectors.toList());
    }
}

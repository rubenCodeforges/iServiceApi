package com.manager.api.item;

import org.springframework.web.multipart.MultipartFile;

public class CreateItemDto extends ItemDto {
    private MultipartFile imageFile;

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}

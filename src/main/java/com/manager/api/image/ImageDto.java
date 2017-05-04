package com.manager.api.image;

import com.manager.api.Api;

public class ImageDto{
    private Long id;
    private String imageUrl;

    public ImageDto(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return Api.URL + "/images/" + getId();
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

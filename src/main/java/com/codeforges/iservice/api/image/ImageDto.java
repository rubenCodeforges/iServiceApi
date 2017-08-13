package com.codeforges.iservice.api.image;

import com.codeforges.iservice.api.Api;

public class ImageDto {
    private Long id;
    private String imageUrl;
    private String thumbUrl;

    public ImageDto() {

    }

    public ImageDto(Long id) {
        this.id = id;
    }

    public ImageDto(Long id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
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

    public String getThumbUrl() {
        return getImageUrl() + "/thumb";
    }
}

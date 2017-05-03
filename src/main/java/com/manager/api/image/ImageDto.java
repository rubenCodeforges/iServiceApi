package com.manager.api.image;

import com.manager.api.Api;
import com.manager.api.item.Item;

public class ImageDto{

    private String id;
    private Item[] items;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getImageUrl() {
        return Api.URL + "/images/" + getId();
    }
}

package com.codeforges.iservice.schemas.common;

import com.codeforges.iservice.schemas.media.Image;

import java.util.Collection;
import java.util.UUID;

public class Thing {
    private UUID uuid;
    private String name;
    private String disambiguatingDescription;
    private String description;
    private String additionalDescription;
    private Collection<Image> images;
}

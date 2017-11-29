package com.codeforges.iservice.schemas.media;

import com.codeforges.iservice.schemas.common.Thing;

import java.util.Collection;

public class Image {
    private Long id;
    private Collection<Thing> things;
    private String filePath;
    private String thumbPath;
}

package com.manager.api.image;

import com.manager.api.Api;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(Api.URL + "/images")
public class ImageController {
    private ImageService imageService;


    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Image create(@RequestParam("uploadedFile") MultipartFile multipartFile) throws IOException {
        return this.imageService.create(multipartFile);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", produces = "image/png")
    public Resource getImageById(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageById(id);
    }
}

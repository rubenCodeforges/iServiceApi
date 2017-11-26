package com.codeforges.iservice.api.partsManager.image;

import com.codeforges.common.files.FileUploadService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    private FileUploadService fileUploadService;
    private ImageRepository imageRepository;

    public ImageService(FileUploadService fileUploadService,
                        ImageRepository imageRepository) {
        this.fileUploadService = fileUploadService;
        this.imageRepository = imageRepository;
    }

    ImageDto create(MultipartFile file) throws IOException {
        Image image = new Image();

        if (!file.isEmpty()) {
            fileUploadService.uploadFile(file);
            image.setFilePath(fileUploadService.getFileFullPath(file));
            image.setThumbPath(fileUploadService.getThumbnailPath(file));
        }

        return ImageMapper.mapToDto(this.imageRepository.save(image));
    }

    Resource getImageById(Long id) throws IOException {
        Image image = imageRepository.findOne(id);
        return new FileSystemResource(image.getFilePath());
    }

    Resource getImageThumbnailById(Long id) throws IOException {
        Image image = imageRepository.findOne(id);
        return new FileSystemResource(image.getThumbPath());
    }
}

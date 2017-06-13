package com.manager.api.image;

import com.manager.api.internal.FileUploadService;
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

    public ImageDto create(MultipartFile file) throws IOException {
        Image image = new Image();

        if (!file.isEmpty()) {
            fileUploadService.uploadFile(file);
            image.setFilePath(fileUploadService.getFileFullPath(file));
        }

        return ImageMapper.mapToDto(this.imageRepository.save(image));
    }

    public Resource getImageById(Long id) throws IOException {
        Image image = imageRepository.findOne(id);
        return new FileSystemResource(image.getFilePath());
    }
}

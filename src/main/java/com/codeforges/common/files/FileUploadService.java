package com.codeforges.common.files;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.http.HTTPException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    @Value("${image.upload.path}")
    public String UPLOAD_PATH;

    @Value("${image.thumbnail.size}")
    private short THUMBNAIL_SIZE;

    //TODO: needs to be modified, add custom exception
    public void uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new HTTPException(500);
        }
        try {
            Path savedFilePath = writeImage(file);
            makeThumbnail(file, savedFilePath);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void makeThumbnail(MultipartFile file, Path savedFilePath) throws IOException {
        Thumbnails.of(savedFilePath.toString())
                .size(THUMBNAIL_SIZE, THUMBNAIL_SIZE)
                .toFile(getThumbnailPath(file));
    }

    private void makeDir() {
        //TODO: Find better place
        File dir = new File(UPLOAD_PATH);
        if (!dir.exists()) {
            new File(UPLOAD_PATH).mkdirs();
        }
    }

    private Path writeImage(MultipartFile file) throws IOException {
        makeDir();
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOAD_PATH + file.getOriginalFilename());
        Files.write(path, bytes);
        return path;
    }

    public String getFileFullPath(MultipartFile file) {
        return UPLOAD_PATH + file.getOriginalFilename();
    }

    public String getThumbnailPath(MultipartFile file) {
        return UPLOAD_PATH + "_thumb_" + THUMBNAIL_SIZE + "_" + file.getOriginalFilename();
    }
}

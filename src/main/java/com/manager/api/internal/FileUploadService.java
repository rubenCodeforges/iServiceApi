package com.manager.api.internal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.http.HTTPException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    @Value("${image.upload.path}")
    public static String UPLOAD_PATH;

    public void uploadFile(MultipartFile file) throws HTTPException {
        if (file.isEmpty()) {
            throw new HTTPException(500);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FileUploadService.UPLOAD_PATH + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (Exception e) {
            throw new HTTPException(500);
        }
    }
}

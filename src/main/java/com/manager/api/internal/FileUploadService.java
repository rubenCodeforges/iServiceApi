package com.manager.api.internal;

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

    //TODO: needs to be modified, add custom exception
    public void uploadFile(MultipartFile file) throws IOException {

        //TODO: Find better place
        File dir = new File(UPLOAD_PATH);
        if (!dir.exists()) {
            new File(UPLOAD_PATH).mkdirs();
        }

        if (file.isEmpty()) {
            throw new HTTPException(500);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_PATH + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public String getFileFullPath(MultipartFile file) {
        return UPLOAD_PATH + file.getOriginalFilename();
    }
}

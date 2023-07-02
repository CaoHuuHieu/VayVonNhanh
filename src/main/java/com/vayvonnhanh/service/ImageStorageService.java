package com.vayvonnhanh.service;


import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;

@Service
public class ImageStorageService {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    public String storeFile(MultipartFile image) {
        try {
        	
        	 String fileExtension = FilenameUtils.getExtension(image.getOriginalFilename());
             String generatedFileName = UUID.randomUUID().toString().replace("-", "");
             generatedFileName = generatedFileName+"."+fileExtension;
        	
        	 Path staticPath = Paths.get("static");
             Path imagePath = Paths.get("images");
             
             if(!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
                 Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
             }
             Path file = CURRENT_FOLDER.resolve(staticPath)
                     .resolve(imagePath).resolve(generatedFileName);
             try (OutputStream os = Files.newOutputStream(file)) {
                 os.write(image.getBytes());
             }
            return generatedFileName;
        }
        catch (IOException exception) {
            throw new RuntimeException("Failed to store file.", exception);
        }
    }
}

package com.tpanh.dinehub.service;

import com.tpanh.dinehub.service.impl.IFilesStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FilesStorageService implements IFilesStorageService {

    @Value("${uploads.root}")
    private String root;

    @Override
    public void init() {
        Path path = Paths.get(root);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public String save(MultipartFile file, String path) throws Exception {
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = UUID.randomUUID().toString() + extension;

        Path dirPath = Paths.get(root + "/" + path);
        Path filePath = dirPath.resolve(newFilename);

        try {
            Files.createDirectories(dirPath); // This line ensures the directory exists
            Files.copy(file.getInputStream(), filePath);
        } catch (IOException e) {
            throw new IOException("Could not save image file: " + newFilename, e);
        }

        return filePath.toString();
    }

    @Override
    public Resource load(String filename) throws Exception {
        Path file = Paths.get(filename).resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new Exception("Could not read file: " + filename);
        }

        return resource;
    }
}

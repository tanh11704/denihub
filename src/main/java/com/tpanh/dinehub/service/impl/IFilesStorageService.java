package com.tpanh.dinehub.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFilesStorageService {
    public void init();

    public String save(MultipartFile file, String path) throws Exception;

    public Resource load(String filename) throws Exception;
}

package com.example.uploaddownloadfile.application;

import com.example.uploaddownloadfile.infraestructure.controller.outputDTO.FileOutputDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    public void init(String path);

    public FileOutputDTO save(MultipartFile file) throws IOException;

    public Resource getById(Long id);

    public Resource getByName(String name);

    public void delete(String path);


}

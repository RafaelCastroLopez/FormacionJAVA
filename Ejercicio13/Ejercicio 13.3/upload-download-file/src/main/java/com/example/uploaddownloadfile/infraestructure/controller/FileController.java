package com.example.uploaddownloadfile.infraestructure.controller;

import com.example.uploaddownloadfile.application.FileStorageService;
import com.example.uploaddownloadfile.infraestructure.controller.outputDTO.FileOutputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import java.io.IOException;

@Controller
@Slf4j
public class FileController {

    @Autowired
    FileStorageService fileStorageService;

    @PostMapping("upload/{type}")
    public ResponseEntity<FileOutputDTO> uploadFile(@RequestParam("file")MultipartFile file, @PathVariable String type) throws IOException {

        log.info(file.getContentType());

        if(!file.getContentType().split("/")[1].equals(type))
            throw new RuntimeException("tipo del archivo invalido");

        return ResponseEntity.status(HttpStatus.OK).body(fileStorageService.save(file));
    }

    @GetMapping("file/{id}")
    public ResponseEntity<Resource> getById(@PathVariable Long id){
        Resource file = (Resource) fileStorageService.getById(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("file/name/{name}")
    public ResponseEntity<Resource> getByName(@PathVariable String name){
        Resource file = (Resource) fileStorageService.getByName(name);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + file.getFilename() + "\"").body(file);
    }
}

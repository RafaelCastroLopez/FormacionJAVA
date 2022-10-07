package com.example.uploaddownloadfile.application;

import com.example.uploaddownloadfile.domain.File;
import com.example.uploaddownloadfile.exceptions.FileNotFound;
import com.example.uploaddownloadfile.infraestructure.controller.outputDTO.FileOutputDTO;
import com.example.uploaddownloadfile.infraestructure.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileStorageSeviceImpl implements FileStorageService{

    @Autowired
    FileRepository fileRepository;

    public Path root;

    @Override
    public void init(String path) {

        try{
            this.root = Paths.get(Objects.isNull(path) ? "src/" : path);
            Files.createDirectory(root);

        } catch (IOException e) {
            throw new RuntimeException("No se ha podido iniciar la carpeta de subida");
        }
    }

    @Override
    public FileOutputDTO save(MultipartFile file){
        try{
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            File newFile = new File( file.getOriginalFilename(), file.getContentType().split("/")[1], new Date());

            fileRepository.save(newFile);

            return new FileOutputDTO(newFile);

        } catch (Exception e) {
            throw new RuntimeException("no se ha podido guardar el archivo." + e.getMessage());
        }
    }

    @Override
    public Resource getById(Long id) {
        try{
            Optional<File> fileOPT = fileRepository.findById(id);

            if(fileOPT.isEmpty())
                throw new FileNotFound("el archivo con ese id no existe");

            File fileObj = fileOPT.get();

            Path file = root.resolve(fileObj.getName());
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            } else {
                throw new FileNotFound("el archivo no existe");
            }
        } catch (MalformedURLException e){
            throw new RuntimeException("ERROR:" + e.getMessage());
        }
    }

    @Override
    public Resource getByName(String name) {
        try{
            Optional<File> fileOPT = fileRepository.findByName(name);

            if(fileOPT.isEmpty())
                throw new FileNotFound("el archivo con ese id no existe");

            File fileObj = fileOPT.get();

            Path file = root.resolve(fileObj.getName());
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            } else {
                throw new FileNotFound("el archivo no existe");
            }
        } catch (MalformedURLException e){
            throw new RuntimeException("ERROR:" + e.getMessage());
        }
    }

    @Override
    public void delete(String path) {
        this.root = Paths.get(Objects.isNull(path)? "src/" : path);
        FileSystemUtils.deleteRecursively(root.toFile());
        fileRepository.deleteAll();
    }
}

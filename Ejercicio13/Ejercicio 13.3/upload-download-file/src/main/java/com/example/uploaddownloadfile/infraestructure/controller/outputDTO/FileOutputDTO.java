package com.example.uploaddownloadfile.infraestructure.controller.outputDTO;

import com.example.uploaddownloadfile.domain.File;
import lombok.Data;

import java.util.Date;

@Data
public class FileOutputDTO {

    public Long id;
    public String name;
    public String metadata;
    public Date upload_date;

    public FileOutputDTO(File file){
        setId(file.getId());
        setName(file.getName());
        setMetadata(file.getMetadata());
        setUpload_date(file.getUpload_date());
    }
}

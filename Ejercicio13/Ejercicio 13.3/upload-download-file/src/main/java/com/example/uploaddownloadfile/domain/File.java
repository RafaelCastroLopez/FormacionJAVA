package com.example.uploaddownloadfile.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String metadata;

    public Date upload_date;

    public File(String name, String metadata, Date upload_date){
        this.name = name;
        this.metadata = metadata;
        this.upload_date = upload_date;
    }
}

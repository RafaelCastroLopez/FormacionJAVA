package com.example.uploaddownloadfile.infraestructure.repository;

import com.example.uploaddownloadfile.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {
    public Optional<File> findByName(String name);
}

package com.example.uploaddownloadfile;

import com.example.uploaddownloadfile.application.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadDownloadFileApplication implements CommandLineRunner {

	@Autowired
	FileStorageService fileStorageService;

	public static void main(String[] args) {
		SpringApplication.run(UploadDownloadFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileStorageService.delete(args[0]);
		fileStorageService.init(args[0]);
	}
}

package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("filename") String fileName)
            throws IOException {
        Path uploads = Paths.get("src/main/resources/static/uploads");
        Files.createDirectories(uploads);
        Files.copy(file.getInputStream(), uploads.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

        return "ok";
    }
}

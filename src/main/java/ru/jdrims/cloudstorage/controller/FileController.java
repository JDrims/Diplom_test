package ru.jdrims.cloudstorage.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.jdrims.cloudstorage.dto.request.FileNameRequest;
import ru.jdrims.cloudstorage.dto.response.FileDescriptionResponse;
import ru.jdrims.cloudstorage.service.FileService;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class FileController {
    private FileService fileService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestHeader("auth-token") String token,
                           @RequestParam("filename") String filename,
                           MultipartFile file) throws IOException {
        fileService.uploadFile(token, filename, file);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/file")
    public ResponseEntity<?> deleteFile(@RequestHeader("auth-token") String token,
                           String filename) {
        fileService.deleteFile(token, filename);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<Resource> getFile(@RequestHeader("auth-token") String token,
                                            String filename) {
        return ResponseEntity
                .ok()
                .body(new ByteArrayResource(fileService.getFile(token, filename)));
    }

    @PutMapping("/file")
    public ResponseEntity<?> editFile(@RequestHeader("auth-token") String token,
                         String filename,
                         @RequestBody FileNameRequest newFileName) {
        fileService.editFileName(token, filename, newFileName);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<FileDescriptionResponse> getFileList(@RequestHeader("auth-token") String token,
                                                     int count) {
        return fileService.getAllFiles(token, count);
    }
}

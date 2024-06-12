package ru.jdrims.cloudstorage.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.jdrims.cloudstorage.dto.request.FileNameRequest;
import ru.jdrims.cloudstorage.dto.response.FileDescriptionResponse;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FileService {

    public void uploadFile(String token, String fileName, MultipartFile file) {

    }

    @Transactional
    public void deleteFile(String token, String fileName) {

    }

    @Transactional
    public byte[] getFile(String token, String fileName) {
        return null;
    }

    @Transactional
    public void editFileName(String token, String fileName, FileNameRequest fileNameRequest) {

    }

    public List<FileDescriptionResponse> getAllFiles(String token, Integer count) {
        return null;
    }

}

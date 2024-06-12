package ru.jdrims.cloudstorage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDescriptionResponse {
    private String fileName;
    private Long size;
}

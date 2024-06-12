package ru.jdrims.cloudstorage.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class FileNameRequest {
    private String fileName;

    @JsonCreator
    public void EditFileName(String fileName) {
        this.fileName = fileName;
    }
}

package ru.jdrims.cloudstorage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileStorage {
    @Id
    @Column(nullable = false, unique = true)
    private String fileName;
    @Column(nullable = false)
    private Long size;
    @Lob
    @Column(nullable = false)
    private byte[] fileContent;
    @ManyToOne
    private User user;

}

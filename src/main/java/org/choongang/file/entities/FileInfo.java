package org.choongang.file.entities;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FileInfo {
    private long seq;
    private String gid;
    private String location;
    private String fileName;
    private String extension;
    private String contentType;
    private int done;
    private LocalDateTime regDt;
}

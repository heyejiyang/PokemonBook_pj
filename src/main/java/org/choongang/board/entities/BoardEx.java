package org.choongang.board.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardEx {
    private long seq;
    private String poster; // 작성자
    private String subject; // 제목
    private String content; // 내용
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}

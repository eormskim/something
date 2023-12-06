package com.example.something.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long boardId; //게시판ID
    private String name; //유저명
    private String title; //제목
    private String content; //내용

    private Long count; //차트 그룹 카운트
}

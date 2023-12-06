package com.example.something.board.controller;

import com.example.something.board.dto.BoardDTO;
import com.example.something.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/api")
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    /**
     * 게시글 목록
     * @return
     */
    @GetMapping(value = "")
    public ResponseEntity<Map> list(){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("data", boardService.selectBoardList());
            result.put("status", "SUCCESS");
        }catch (DataAccessException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }

        return ResponseEntity.ok(result);
    }

    /**
     * 게시글 저장
     * @param boardDTO
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Map> editBoard(@RequestBody BoardDTO boardDTO){
        Map<String, Object> result = new HashMap<>();
        try{
            int count = boardService.saveBoard(boardDTO);
            result.put("insert count", count);
            result.put("status", "SUCCESS");
        }catch (SQLException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 게시글 상세
     * @param boardId
     * @return
     */
    @GetMapping("/detail/{boardId}")
    public ResponseEntity<Map> detailBoard(@PathVariable Long boardId){
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("data", boardService.detailBoard(boardId));
            result.put("status", "SUCCESS");
        }catch (DataAccessException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 게시글 업데이트
     * @param boardDTO
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Map> updateBoard(@RequestBody BoardDTO boardDTO){
        Map<String, Object> result = new HashMap<>();
        try {
            int count = boardService.updateBoard(boardDTO);
            result.put("update count", count);
            result.put("status", "SUCCESS");
        }catch (SQLException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 게시글 삭제
     * @param boardDTO
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Map> deleteBoard(@RequestBody BoardDTO boardDTO){
        Map<String, Object> result = new HashMap<>();
        try {
            int count = boardService.deleteBoard(boardDTO);
            result.put("update count", count);
            result.put("status", "SUCCESS");
        }catch (DataAccessException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 차트 데이터 기본
     * @return
     */
    @GetMapping("/chart")
    public ResponseEntity<Map> chartBoardData(){
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("data", boardService.selectBoardChartData(""));
            result.put("status", "SUCCESS");
        }catch (DataAccessException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 차트 데이터 검색
     * @param name - 글 작성자 이름 검색
     * @return
     */
    @GetMapping("/chart/{name}")
    public ResponseEntity<Map> chartBoardData(@PathVariable String name){
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("data", boardService.selectBoardChartData(name));
            result.put("status", "SUCCESS");
        }catch (DataAccessException e){
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        return ResponseEntity.ok(result);
    }
}

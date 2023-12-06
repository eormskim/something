package com.example.something.board.service;

import com.example.something.board.dto.BoardDTO;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {

    //게시글 목록
    List<BoardDTO> selectBoardList() throws DataAccessException;

    //게시글 등록
    int saveBoard(BoardDTO boardDTO) throws SQLException;

    //게시글 상세
    BoardDTO detailBoard(Long boardId) throws NullPointerException;

    //게시글 업데이트
    int updateBoard(BoardDTO boardDTO) throws SQLException;

    //게시글 삭제
    int deleteBoard(BoardDTO boardDTO) throws DataAccessException;

    //차트 데이터
    List<BoardDTO> selectBoardChartData(String name) throws DataAccessException;
}

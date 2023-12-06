package com.example.something.board.mapper;

import com.example.something.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    List<BoardDTO> selectBoardList();
    int saveBoard(BoardDTO boardDTO);
    BoardDTO detailBoard(Long boardId);
    int updateBoard(BoardDTO boardDTO);
    int deleteBoard(BoardDTO boardDTO);
    List<BoardDTO> selectBoardChartData(String name);
}

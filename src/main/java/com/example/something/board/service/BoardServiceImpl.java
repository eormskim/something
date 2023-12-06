package com.example.something.board.service;

import com.example.something.board.dto.BoardDTO;
import com.example.something.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    //게시글 목록
    @Override
    public List<BoardDTO> selectBoardList() throws DataAccessException {
        return boardMapper.selectBoardList();
    }

    //게시글 저장
    @Transactional
    @Override
    public int saveBoard(BoardDTO boardDTO) throws SQLException {
        return boardMapper.saveBoard(boardDTO);
    }

    //게시글 상세
    @Override
    public BoardDTO detailBoard(Long boardId) throws NullPointerException{
        return boardMapper.detailBoard(boardId);
    }

    //게시글 업데이트
    @Override
    public int updateBoard(BoardDTO boardDTO) throws SQLException {
        return boardMapper.updateBoard(boardDTO);
    }

    //게시글 삭제
    @Override
    public int deleteBoard(BoardDTO boardDTO) throws DataAccessException {
        return boardMapper.deleteBoard(boardDTO);
    }

    //차트 데이터
    @Override
    public List<BoardDTO> selectBoardChartData(String name) throws DataAccessException {
        return boardMapper.selectBoardChartData(name);
    }

}

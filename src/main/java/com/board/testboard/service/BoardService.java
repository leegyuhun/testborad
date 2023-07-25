package com.board.testboard.service;

import com.board.testboard.domain.Board;

import java.util.List;

public interface BoardService {

    void saveBoard(Board board);

    List<Board> findBoardAll();

    List<Board> findBoard(String title);
}

package com.board.testboard.service.impl;

import com.board.testboard.domain.Board;
import com.board.testboard.repository.BoardRepository;
import com.board.testboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void saveBoard(Board board) {
        boardRepository.saveBoard(board);
    }

    @Override
    public List<Board> findBoardAll() {
        return boardRepository.findBoardsAll();
    }

    @Override
    public List<Board> findBoard(String title) {
        return boardRepository.findBoards(title);
    }
}

package com.board.testboard.controller;

import com.board.testboard.domain.Board;
import com.board.testboard.domain.BoardForm;
import com.board.testboard.domain.Member;
import com.board.testboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/new")
    public String createForm(Model model){
        model.addAttribute("form", new BoardForm());
        return "board/createBoard";
    }

    @PostMapping("board/new")
    public String create(BoardForm form) {
        Board board = new Board();
        board.setId(form.getId());
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());

        System.out.println("board = " + board.toString());
        boardService.saveBoard(board);

        return "redirect:/board/boardList";
    }

    @GetMapping("board/boardList")
    public String boardList(Model model) {
        List<Board> boardList = boardService.findBoardAll();

        model.addAttribute("list", boardList);

        return "board/boardList";
    }
}

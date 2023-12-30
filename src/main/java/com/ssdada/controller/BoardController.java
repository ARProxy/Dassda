package com.ssdada.controller;

import com.ssdada.dto.BoardDto;
import com.ssdada.dto.DiaryDto;
import com.ssdada.entity.Board;
import com.ssdada.entity.Diary;
import com.ssdada.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
@CrossOrigin("https://editor.swagger.io")
public class BoardController {
    private final BoardService boardService;
    @PostMapping("/add")
    public ResponseEntity<Void> makeBoardTitle(@RequestBody BoardDto boardDto) {
        String title = boardDto.getBoardTitle();
        boardService.insertBoardTitle(title);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        System.out.println(id);
        boardService.deleteBoard(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    public ResponseEntity<List<Board>> getBoard() {
        List<Board> boards = boardService.getBoard();
        return ResponseEntity.ok(boards);
    }
    @PostMapping("/update")
    public ResponseEntity<Board> updateBoard(@RequestBody BoardDto boardDto) {
        Board updateBoard = boardService.updateBoard(boardDto);
        return ResponseEntity.ok(updateBoard);
    }
    @GetMapping("/count")
    public ResponseEntity<Void> allCountBoard() {
        return null;
    }
    @GetMapping("/members/count")
    public ResponseEntity<Void> membersCountBoard() {
        return null;
    }
    @GetMapping("/add/badge")
    public ResponseEntity<Void> newBadgeBoard() {
        return null;
    }
}

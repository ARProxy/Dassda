package com.ssdada.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("https://editor.swagger.io")
public class BoardController {
    private final BoardService boardService;
    @PostMapping("addBoard")
    public ResponseEntity<Void> makeBoardTitle(@RequestBody BoardDto boardDto) {
        String name = boardDto.
    }
}

package com.ssdada.service;

import com.ssdada.dto.BoardDto;
import com.ssdada.dto.DiaryDto;
import com.ssdada.entity.Board;
import com.ssdada.entity.Diary;
import com.ssdada.repository.BoardRepository;
import com.ssdada.repository.DiaryImgRepository;
import com.ssdada.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final DiaryRepository diaryRepository;
    private final DiaryImgRepository diaryImgRepository;

    @Value("${itemImgLocation}")
    private String itemImgLocation;

    public void insertBoardTitle(String title) {
        Board board = new Board();
        board.setTitle(title);
        boardRepository.save(board);
    }
    public void deleteBoard(Long id) {
        Optional<Board> deleteName = boardRepository.findById(id);
        if(deleteName.isPresent()) {
            boardRepository.delete(deleteName.get());
        } else {
            throw new IllegalStateException("해당 일기장 존재하지 않음");
        }
    }
    public List<Board> getBoard() {
        return boardRepository.findAll();
    }
    public Board updateBoard(BoardDto boardDto) {
        Optional<Board> existingBoard = boardRepository.findById(boardDto.getId());
        if(existingBoard.isPresent()) {
            Board board = existingBoard.get();
            board.setTitle(boardDto.getUpdateTitle());
            boardRepository.save(board);
            return board;
        } else {
            throw new IllegalStateException("해당 일기장 없음");
        }
    }


}

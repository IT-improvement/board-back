package com.reactsrping.boardback.service;

import org.springframework.http.ResponseEntity;

import com.reactsrping.boardback.dto.request.board.PostBoardRequestDto;
import com.reactsrping.boardback.dto.response.board.PostBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}

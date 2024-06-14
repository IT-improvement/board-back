package com.reactsrping.boardback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reactsrping.boardback.dto.request.board.PostBoardRequestDto;
import com.reactsrping.boardback.dto.response.board.PostBoardResponseDto;
import com.reactsrping.boardback.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardservice;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @RequestBody @Valid PostBoardRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostBoardResponseDto> response = boardservice.postBoard(requestBody, email);
        return response;
    }
}

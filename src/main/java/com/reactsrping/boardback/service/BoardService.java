package com.reactsrping.boardback.service;

import org.springframework.http.ResponseEntity;

import com.reactsrping.boardback.dto.request.board.PostBoardRequestDto;
import com.reactsrping.boardback.dto.response.board.PostBoardResponseDto;
import com.reactsrping.boardback.dto.response.board.GetBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber); 
    //description: Intger boardNumber 받는 이유 -> PathValue에서 boardNumber를 받아오기 때문
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}

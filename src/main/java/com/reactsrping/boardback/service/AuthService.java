package com.reactsrping.boardback.service;

import org.springframework.http.ResponseEntity;

import com.reactsrping.boardback.dto.request.auth.SignInRequestDto;
import com.reactsrping.boardback.dto.request.auth.SignUpRequestDto;
import com.reactsrping.boardback.dto.response.auth.SignInResponseDto;
import com.reactsrping.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}

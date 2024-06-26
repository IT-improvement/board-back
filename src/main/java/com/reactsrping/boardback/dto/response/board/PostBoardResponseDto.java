package com.reactsrping.boardback.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.reactsrping.boardback.common.ResponseCode;
import com.reactsrping.boardback.common.ResponseMessage;
import com.reactsrping.boardback.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostBoardResponseDto extends ResponseDto{

    private PostBoardResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCES);
    }
    
    public static ResponseEntity<PostBoardResponseDto> succsss(){
        PostBoardResponseDto result = new PostBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}

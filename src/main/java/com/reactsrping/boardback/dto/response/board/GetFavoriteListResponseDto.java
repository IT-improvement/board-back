package com.reactsrping.boardback.dto.response.board;

import lombok.Getter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.reactsrping.boardback.common.ResponseCode;
import com.reactsrping.boardback.common.ResponseMessage;
import com.reactsrping.boardback.dto.object.FavoriteListItem;
import com.reactsrping.boardback.dto.response.ResponseDto;

@Getter
public class GetFavoriteListResponseDto extends ResponseDto{
    
    private List<FavoriteListItem> favoriteList;

    private GetFavoriteListResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCES);
    }

    public static ResponseEntity<GetFavoriteListResponseDto> success(){
        GetFavoriteListResponseDto result = new GetFavoriteListResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD,ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }

}

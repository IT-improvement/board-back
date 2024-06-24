package com.reactsrping.boardback.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.reactsrping.boardback.common.ResponseCode;
import com.reactsrping.boardback.common.ResponseMessage;
import com.reactsrping.boardback.dto.response.ResponseDto;
import com.reactsrping.boardback.entity.ImageEntity;
import com.reactsrping.boardback.repository.resultSet.GetBoardResultSet;

import lombok.Getter;

@Getter
public class GetBoardResponseDto extends ResponseDto{

    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private String writeDatetime;
    private String writeEmail;
    private String writerNickname;
    private String writerProfileImage;
    
    private GetBoardResponseDto(GetBoardResultSet resultSet, List<ImageEntity> imageEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCES);
        
        List<String> boardImageList = new ArrayList<>();
        for(ImageEntity imageEntity: imageEntities){
            String boardImage = imageEntity.getImage();
            boardImageList.add(boardImage);
        }


        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.boardImageList=boardImageList;
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writeEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerProfileImage = resultSet.getWriterProfileImage();
    }


    // description: 성공했을때는 ResponseEntity 제네릭 타입으로 GetBoardResponseDto를 생성해서 반환(캡슐화)
    public static ResponseEntity<GetBoardResponseDto> success(GetBoardResultSet resultSet, List<ImageEntity> imageEntities){
        GetBoardResponseDto result = new GetBoardResponseDto(resultSet, imageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}

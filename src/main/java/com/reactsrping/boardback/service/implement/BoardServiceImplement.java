package com.reactsrping.boardback.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.reactsrping.boardback.dto.request.board.PostBoardRequestDto;
import com.reactsrping.boardback.dto.response.ResponseDto;
import com.reactsrping.boardback.dto.response.board.GetBoardResponseDto;
import com.reactsrping.boardback.dto.response.board.PostBoardResponseDto;
import com.reactsrping.boardback.entity.BoardEntity;
import com.reactsrping.boardback.entity.ImageEntity;
import com.reactsrping.boardback.repository.BoardRepository;
import com.reactsrping.boardback.repository.ImageRepository;
import com.reactsrping.boardback.repository.UserRepository;
import com.reactsrping.boardback.repository.resultSet.GetBoardResultSet;
import com.reactsrping.boardback.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {

        GetBoardResultSet resultSet =null; 
        List<ImageEntity> imageEntities = new ArrayList<>();
        try {
            
            resultSet = boardRepository.getBoard(boardNumber);
            if(resultSet == null) return GetBoardResponseDto.noExistBoard();
            
            imageEntities = imageRepository.findByBoardNumber(boardNumber);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity);


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBoardResponseDto.success(resultSet, imageEntities);

    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email) {
        
        try {
        
            boolean existedEmail = userRepository.existsByEmail(email);
            if(!existedEmail) return PostBoardResponseDto.notExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            boardRepository.save(boardEntity);

            int boardNumber = boardEntity.getBoardNumber();

            List<String> boardImageList = dto.getBoardImageList();
            List<ImageEntity> imageEntities = new ArrayList<>();

            for(String image: boardImageList){
                ImageEntity imageEntity = new ImageEntity(boardNumber, image);
                imageEntities.add(imageEntity);
            }
            imageRepository.saveAll(imageEntities);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.succsss();
    }
    
}

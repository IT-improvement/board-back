package com.reactsrping.boardback.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.reactsrping.boardback.dto.request.board.PostBoardRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
@Table(name = "board")
public class BoardEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    @Column(name ="")
    private String title;
    private String content; 
    private String writeDatetime;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writerEmail;

    public BoardEntity(PostBoardRequestDto dto ,String email){
        
        Date now = Date.from(Instant.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
        String writeDatetime = sdf.format(now);

        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writeDatetime = writeDatetime;
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.viewCount = 0;
        this.writerEmail = email;
    }

    public void increaseViewCount(){
        this.viewCount++;
    }

}

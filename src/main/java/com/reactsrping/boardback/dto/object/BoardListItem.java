package com.reactsrping.boardback.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardListItem {
    private int boardNumber;
    private String title;
    private String conent;
    private String boardTitleImage;
    private int favoriteCount;
    private int viewCount;
    private String writeDatetime;
    private String wirterNickname;
    private String writeProfileImage;
}

package com.reactsrping.boardback.entity;

import com.reactsrping.boardback.entity.primaryKey.FavoritePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favorite")
@Entity(name = "favorite")
@IdClass(FavoritePk.class)
public class FavoriteEntity {
    
    @Id
    private String userEmail;
    
    @Id
    private int boardNumber;

}

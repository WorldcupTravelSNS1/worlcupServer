package com.example.travelsnsproject.config.Dto;


import com.example.travelsnsproject.config.entity.BoardImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardImageDto {
    private Long id;
    private String imageUrl;

    public BoardImageDto(BoardImage boardImage){
        this.id = boardImage.getId();
        this.imageUrl = boardImage.getImageUrl();
    }
}

package com.example.travelsnsproject.domain.board.response;


import com.example.travelsnsproject.config.Dto.BoardImageDto;
import com.example.travelsnsproject.config.Dto.CommentDto;
import com.example.travelsnsproject.config.Dto.MemberDto;
import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.BoardImage;
import com.example.travelsnsproject.config.entity.Comment;
import com.querydsl.core.Tuple;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class BoardGetResponse{
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String tema;
    private Integer likeCount;
    private Long memberId;
    private String memberName;
    private String boardImages;
    private String boardImageIds;

//    private MemberDto member;
//    private List<CommentDto> comments;

    @QueryProjection
    public BoardGetResponse(Board board){
        this.id= board.getId();
        this.title= board.getTitle();
        this.content= board.getContent();
        this.createAt=board.getCreateAt();
        this.tema= board.getTema();
        this.likeCount= board.getLikeCount();
        this.memberId = getMemberId();
        this.memberName = getMemberName();
        this.boardImages = getBoardImages();
        this.boardImageIds = getBoardImageIds();
    }

}

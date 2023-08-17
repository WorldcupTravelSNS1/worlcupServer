package com.example.travelsnsproject.domain.board.response;


import com.example.travelsnsproject.config.Dto.MemberDto;
import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.Comment;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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


    private MemberDto member;
    private List<Comment> comments;

    @QueryProjection
    public BoardGetResponse(Board board){
        this.id= board.getId();
        this.title= board.getTitle();
        this.content= board.getContent();
        this.createAt=board.getCreateAt();
        this.tema= board.getTema();
        this.likeCount= board.getLikeCount();
        this.member=new MemberDto(board.getMember());
        this.comments=board.getComments();
    }

}

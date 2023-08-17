package com.example.travelsnsproject.config.entity;


import com.example.travelsnsproject.domain.board.request.SaveCommentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    @JsonIgnore
    private Board board;
    private String comment;


    public Comment(Long boardId,SaveCommentRequest saveCommentRequest){
        this.member=Member.builder().id(saveCommentRequest.getMemberId()).build();
        this.board= Board.builder().id(boardId).build();
        this.comment=saveCommentRequest.getComment();
    }
}

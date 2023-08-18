package com.example.travelsnsproject.config.Dto;

import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommentDto {
    private Long id;
    private MemberDto member;
    private String comment;
    public CommentDto (Comment comment){
        this.id= comment.getId();
        this.comment=comment.getComment();
        this.member = new MemberDto(comment.getMember());
    }

}

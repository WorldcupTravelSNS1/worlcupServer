package com.example.travelsnsproject.domain.board.response;

import com.example.travelsnsproject.config.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentSaveResponse {
    private Long id;
    private Long memberid;

    public CommentSaveResponse(Comment comment){
        this.id= comment.getId();
        this.memberid=comment.getMember().getId();
    }
}

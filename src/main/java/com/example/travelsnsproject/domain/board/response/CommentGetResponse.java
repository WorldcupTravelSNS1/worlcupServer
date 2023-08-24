package com.example.travelsnsproject.domain.board.response;


import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.Comment;
import com.example.travelsnsproject.config.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentGetResponse {
    private Long id;
    private Long memberId;
    private Long boardId;
    private String comment;
    private String memberName;

    public CommentGetResponse(Comment comment){
        this.id = comment.getId();
        this.memberId = comment.getMember().getId();
        this.boardId = comment.getBoard().getId();
        this.comment = comment.getComment();
        this.memberName = comment.getMember().getName();
    }
}

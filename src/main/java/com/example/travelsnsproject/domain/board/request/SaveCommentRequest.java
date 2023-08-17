package com.example.travelsnsproject.domain.board.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveCommentRequest {
    private Long memberId;
    private String comment;


}

package com.example.travelsnsproject.domain.board.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveBoardRequest {
    private Long memberId;
    private String title;
    private String content;
    private String tema;
}

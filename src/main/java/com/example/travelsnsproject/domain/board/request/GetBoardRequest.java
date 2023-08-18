package com.example.travelsnsproject.domain.board.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetBoardRequest {
    private String title;
    private String content;
    private String tema;
    private Integer pageNumber=0;
    private Integer PageSize=10;
}

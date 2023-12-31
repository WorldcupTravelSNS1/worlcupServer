package com.example.travelsnsproject.domain.board.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBoardRequest {
    private String title;
    private String content;
    private List<Long> boardImageId;
    private List<String> imageUrl;
}

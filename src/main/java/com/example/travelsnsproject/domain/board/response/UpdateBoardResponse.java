package com.example.travelsnsproject.domain.board.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateBoardResponse {
    private List<Long> boardImageId;
}

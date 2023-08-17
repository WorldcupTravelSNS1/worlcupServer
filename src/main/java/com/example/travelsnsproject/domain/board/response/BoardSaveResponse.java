package com.example.travelsnsproject.domain.board.response;

import com.example.travelsnsproject.config.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveResponse {
    private Long id;
    private LocalDateTime createAt;
    private Long memberId;

    public BoardSaveResponse(Board board){
        this.id = board.getId();
        this.createAt = board.getCreateAt();
        this.memberId = board.getMember().getId();//여기 비효율적 고도화 필요
    }

}

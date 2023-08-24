package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.domain.board.request.GetBoardRequest;
import com.example.travelsnsproject.domain.board.response.BoardGetResponse;
import org.springframework.data.domain.Page;


public interface CustomBoardRepository {

    public Page<BoardGetResponse> getBoard(GetBoardRequest getBoardRequest);
    public Page<BoardGetResponse> getBlockedBoard(GetBoardRequest getBoardRequest);

    public Page<BoardGetResponse> getBoardById(Long boardId);
}

package com.example.travelsnsproject.domain.board.service;

import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.domain.board.repository.BoardRepository;
import com.example.travelsnsproject.domain.board.request.GetBoardRequest;
import com.example.travelsnsproject.domain.board.request.SaveBoardRequest;
import com.example.travelsnsproject.domain.board.request.UpdateBoardRequest;
import com.example.travelsnsproject.domain.board.response.BoardGetResponse;
import com.example.travelsnsproject.domain.board.response.BoardSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public Page<BoardGetResponse> getBoard(GetBoardRequest getBoardRequest){
        return boardRepository.getBoard(getBoardRequest);
    }

    public BoardSaveResponse saveBoard(SaveBoardRequest saveBoardRequest){
        Board thisBoard = boardRepository.save(new Board(saveBoardRequest));
        return new BoardSaveResponse(thisBoard);
    }

    public void saveBoard(Board board){
        Board thisBoard = boardRepository.save(board);
    }

    public void deleteBoard(Long boardId){
        boardRepository.deleteById(boardId);
    }

    public void updateBoard(Long boardId, UpdateBoardRequest updateBoardRequest){
        Board thisBoard = boardRepository.findById(boardId).get();
        thisBoard.setContent(updateBoardRequest.getContent());
        thisBoard.setTitle(updateBoardRequest.getTitle());
        boardRepository.save(thisBoard);
    }

}

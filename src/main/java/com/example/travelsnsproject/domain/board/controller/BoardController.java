package com.example.travelsnsproject.domain.board.controller;

import com.example.travelsnsproject.config.aspect.TokenCheck;
import com.example.travelsnsproject.domain.board.request.GetBoardRequest;
import com.example.travelsnsproject.domain.board.request.SaveBoardRequest;
import com.example.travelsnsproject.domain.board.request.UpdateBoardRequest;
import com.example.travelsnsproject.domain.board.response.BoardGetResponse;
import com.example.travelsnsproject.domain.board.response.BoardSaveResponse;
import com.example.travelsnsproject.domain.board.response.UpdateBoardResponse;
import com.example.travelsnsproject.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Page<BoardGetResponse> getBoard(
            GetBoardRequest getBoardRequest){
        //동적 쿼리 만들어서 리턴
        //여기서 fetchjoin해서 리턴해야 훨씬 효율적인데 따로 규현하지 않고 리턴하고있다.
        //차후에 고도화할 때 fetchjoin하고, BoardResponse를 만들어서 리턴하도록 하자
        return boardService.getBoard(getBoardRequest);
    }

    @TokenCheck
    @PostMapping
    public BoardSaveResponse saveBoard(@RequestBody SaveBoardRequest saveBoardRequest){
        //board 저장
        return boardService.saveBoard(saveBoardRequest);
    }

    @TokenCheck
    @DeleteMapping("/{boardid}")
    public void deleteBoard(@PathVariable("boardid")Long boardId){
        //board삭제기능 구현 -> 작성자만 삭제 가능(생각해보니까 이걸 굳이 여기서 해야하나?)
        //token에서 멤버
        boardService.deleteBoard(boardId);
    }

    @TokenCheck
    @PutMapping("/{boardid}")
    public UpdateBoardResponse updateBoard(@PathVariable("boardid")Long boardId,
                                           @RequestBody UpdateBoardRequest updateBoardRequest){
        return boardService.updateBoard(boardId,updateBoardRequest);
    }

}

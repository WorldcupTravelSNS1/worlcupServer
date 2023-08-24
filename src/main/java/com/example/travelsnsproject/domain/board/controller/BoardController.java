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
@CrossOrigin("*")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Page<BoardGetResponse> getBoard(
            GetBoardRequest getBoardRequest){
        //동적 쿼리 만들어서 리턴
        return boardService.getBoard(getBoardRequest);
    }

    @GetMapping("{boardId}")
    public Page<BoardGetResponse> getBoard(
            @PathVariable("boardId") Long boardId){
        //동적 쿼리 만들어서 리턴
        return boardService.getBoardById(boardId);
    }

    @GetMapping("/blocked")
    public Page<BoardGetResponse> getBlockedBoard(
            GetBoardRequest getBoardRequest){
        //동적 쿼리 만들어서 리턴
        return boardService.getBlockedBoard(getBoardRequest);
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
        //boardImage부터 먼저 다 삭제하고 삭제하도록 재 구현해야함
        //원래 위의 로직이었지만 isAvailable을 추가하여 해당
        boardService.deleteBoard(boardId);
    }

    @TokenCheck
    @DeleteMapping("/restore/{boardid}")
    public void RestoreBoard(@PathVariable("boardid")Long boardId){
        //board삭제기능 구현 -> 작성자만 삭제 가능(생각해보니까 이걸 굳이 여기서 해야하나?)
        //token에서 멤버
        //boardImage부터 먼저 다 삭제하고 삭제하도록 재 구현해야함
        //원래 위의 로직이었지만 isAvailable을 추가하여 해당
        boardService.restoreBoard(boardId);
    }


    @TokenCheck
    @PutMapping("/{boardid}")
    public UpdateBoardResponse updateBoard(@PathVariable("boardid")Long boardId,
                                           @RequestBody UpdateBoardRequest updateBoardRequest){
        return boardService.updateBoard(boardId,updateBoardRequest);
    }

}

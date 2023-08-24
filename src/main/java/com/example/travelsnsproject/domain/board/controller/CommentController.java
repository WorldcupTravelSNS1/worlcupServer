package com.example.travelsnsproject.domain.board.controller;


import com.example.travelsnsproject.config.aspect.TokenCheck;
import com.example.travelsnsproject.domain.board.request.SaveCommentRequest;
import com.example.travelsnsproject.domain.board.request.UpdateCommentRequest;
import com.example.travelsnsproject.domain.board.response.CommentSaveResponse;
import com.example.travelsnsproject.domain.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;

//    @GetMapping("/{boardId}")

    @TokenCheck
    @PostMapping("/{boardId}")
    public CommentSaveResponse saveComment(@PathVariable("boardId")Long boardId,
                                           @RequestBody SaveCommentRequest saveCommentRequest){
        return commentService.saveComment(boardId,saveCommentRequest);
    }

    @TokenCheck
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        //delete comment
        commentService.deleteComment(commentId);
    }

    @TokenCheck
    @PutMapping("/{commentId}")
    public void updateComment(@PathVariable("commentId") Long commentId,
                              @RequestBody UpdateCommentRequest updateCommentRequest){
        commentService.updateComment(commentId,updateCommentRequest);
    }

}

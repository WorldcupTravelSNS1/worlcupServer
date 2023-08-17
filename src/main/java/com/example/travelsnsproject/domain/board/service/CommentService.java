package com.example.travelsnsproject.domain.board.service;


import com.example.travelsnsproject.config.entity.Comment;
import com.example.travelsnsproject.domain.board.repository.CommentRepository;
import com.example.travelsnsproject.domain.board.request.SaveCommentRequest;
import com.example.travelsnsproject.domain.board.request.UpdateCommentRequest;
import com.example.travelsnsproject.domain.board.response.CommentSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentSaveResponse saveComment(Long boardId, SaveCommentRequest saveCommentRequest){
        Comment thisComment = commentRepository.save(new Comment(boardId,saveCommentRequest));
        return new CommentSaveResponse(thisComment);
    }

    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    public void updateComment(Long commentId, UpdateCommentRequest updateCommentRequest){
        Comment comment = commentRepository.findById(commentId).get();
        comment.setComment(updateCommentRequest.getComment());
        commentRepository.save(comment);
    }

}
